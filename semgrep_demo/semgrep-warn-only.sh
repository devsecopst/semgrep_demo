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
  --config p/java \
  --config p/jwt \
  --config p/dockerfile \
  --config p/docker-compose \
  --config p/findsecbugs \
  --skip-unknown-extensions \
  --disable-version-check \
  --quiet \
  .

echo -e "\n${GREEN}✔️Semgrep security code scan completed.\n\r${NC} ${RED}📄 For any questions or concerns, please contact the Security Team.${NC}"

exit 0
