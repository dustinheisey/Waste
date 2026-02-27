import type { Config } from "prettier";

export default {
  printWidth: 120,
  tabWidth: 2,
  singleQuote: false,
  trailingComma: "none",
  semi: true,
  arrowParens: "avoid",
  bracketSpacing: true,
  bracketSameLine: false,
  organizeImportsSkipDestructiveCodeActions: true,
  plugins: ["prettier-plugin-organize-imports"],
  endOfLine: "lf",
  insertPragma: false,
  quoteProps: "as-needed",
  requirePragma: false,
  useTabs: false,
} satisfies Config;
