#!/bin/bash

set -e

RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
NC='\033[0m' # No Color

echo "🔧 Starting Semgrep pre-commit hook setup..."

# Check for Homebrew
if ! command -v brew &>/dev/null; then
  echo -e "${RED}❌ Homebrew not found. Please install Homebrew first: https://brew.sh/${NC}"
  exit 1
fi

# Install Python 3 if not available
if ! command -v python3 &>/dev/null; then
  echo -e "${YELLOW}➕ Installing Python 3 via Homebrew...${NC}"
  brew install python
fi

# Ensure pip3 is available
if ! command -v pip3 &>/dev/null; then
  echo -e "${RED}❌ pip3 not found after Python install. Aborting.${NC}"
  exit 1
fi

# Install pre-commit if missing
if ! command -v pre-commit &>/dev/null; then
  echo -e "${YELLOW}➕ Installing pre-commit via pip3...${NC}"
  pip3 install --user pre-commit
fi

# Install Semgrep if missing
if ! command -v semgrep &>/dev/null; then
  echo -e "${YELLOW}➕ Installing Semgrep via Homebrew...${NC}"
  brew install semgrep
fi



# Copy pre-commit config and hook script
echo -e "${GREEN}📁 Copying .pre-commit-config.yaml and semgrep-warn-only.sh...${NC}"
cat > .pre-commit-config.yaml <<'EOF'
repos:
  - repo: local
    hooks:
      - id: semgrep-warn-only
        name: Semgrep (Warn Only)
        entry: bash ./semgrep-warn-only.sh
        language: system
        pass_filenames: false
        verbose: true
EOF

cat > semgrep-warn-only.sh <<'EOF'
#!/bin/bash
RED='\033[0;31m'
GREEN='\033[0;32m'
NC='\033[0m' # No Color

echo "🔍 Running Semgrep scan (warn-only)..."

semgrep login

semgrep \
  --config=auto \
  --pro \
  --config p/gitleaks \
  --config p/secrets \
  --config p/command-injection \
  --config p/insecure-transport \
  --config p/sql-injection \
  --config p/comment \
  --config p/cwe-top-25 \
  --config p/default \
  --config p/owasp-top-ten \
  --config p/security-audit \
  --config p/secure-defaults \
  --config p/xss \
  --config p/javascript \
  --config p/react \
  --config p/nextjs \
  --config p/java \
  --config p/jwt \
  --config p/mobsfscan \
  --config p/kotlin \
  --config p/swift \
  --config p/dockerfile \
  --config p/docker-compose \
  --config p/security-code-scan \
  --config p/findsecbugs \
  --skip-unknown-extensions \
  --disable-version-check \
  --quiet \
  .
echo -e "\n${GREEN}✔️Semgrep security code scan completed.\n\r${NC} ${RED}📄 For any questions or concerns, please contact the Security Team.${NC}"
exit 0
EOF

chmod +x semgrep-warn-only.sh

# Install the pre-commit hook
echo -e "${GREEN}🔧 Installing Git pre-commit hook...${NC}"
pre-commit install

echo -e "${GREEN}✅ Semgrep pre-commit hook installed successfully.${NC}"

