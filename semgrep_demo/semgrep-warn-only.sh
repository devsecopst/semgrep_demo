#!/bin/bash
RED='\033[0;31m'
GREEN='\033[0;32m'
NC='\033[0m' # No Color

echo "🔍 Running Semgrep scan (warn-only)..."
semgrep login

semgrep ci --code --secrets --include $(git diff --name-only --cached)

echo -e "\n${GREEN}✔️Semgrep security code scan completed.\n\r${NC} ${RED}📄 For any questions or concerns, please contact the Security Team.${NC}"

exit 0
