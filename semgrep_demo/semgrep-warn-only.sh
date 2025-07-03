#!/bin/bash
RED='\033[0;31m'
GREEN='\033[0;32m'
NC='\033[0m' # No Color

echo "🔍 Running Semgrep scan (warn-only)..."

# Exit early if no files passed
if [ "$#" -eq 0 ]; then
  echo "No staged files to scan."
  exit 0
fi

# Filter for Java files only
JAVA_FILES=()
for file in "$@"; do
  if [[ "$file" == *.java ]] && [[ -f "$file" ]]; then
    JAVA_FILES+=("$file")
  fi
done

if [ ${#JAVA_FILES[@]} -eq 0 ]; then
  echo "No staged Java files to scan."
  exit 0
fi

# Optional: semgrep login once per environment, not on every run
# Commented out, assuming you logged in before
# semgrep login 1>/dev/null

# Run semgrep scan only on staged java files
semgrep ci --code --secrets --dry-run "${JAVA_FILES[@]}" 2>/dev/null

echo -e "\n${GREEN}✔️ Semgrep security code scan completed.\n\r${NC} ${RED}📄 For any questions or concerns, please contact the Security Team.${NC}"

exit 0
