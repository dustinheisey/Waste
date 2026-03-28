// eslint-disable @typescript-eslint/no-non-null-assertion
import {
  alchemy,
  builders,
  flatten,
  furnace,
  salvage,
  type AlchemyCfg,
  type BuilderRecipeCfg,
  type Flatten,
  type FurnaceRecipeCfg,
  type HasId,
  type NoId,
  type SalvageRecipeCfg,
  type WorkbenchCfg
} from "hytale-generators";
import type { SetOptional } from "type-fest";
import type { SortingRecipeCfg } from "./generators/sorting.ts";
import { sorting } from "./generators/sorting.ts";

type RegistrationCtx = "dump" | "patch" | "city" | "toxicWastes" | "factory" | "trashTowers";
export type Cfg<T> = Partial<Record<RegistrationCtx, T[]>>;

type RecipeCfg = {
  workbench: SetOptional<NoId<WorkbenchCfg>, "output" | "time" | "categories">;
  salvage: SetOptional<NoId<SalvageRecipeCfg>, "input" | "time">;
  furnace: SetOptional<NoId<FurnaceRecipeCfg>, "input" | "time">;
  sorting: SetOptional<NoId<SortingRecipeCfg>, "input" | "time">;
  alchemy: SetOptional<NoId<AlchemyCfg>, "input" | "time" | "categories">;
  builders: SetOptional<NoId<BuilderRecipeCfg>, "input">;
};
type RecipeType = keyof RecipeCfg;
type RecipeData = {
  workbench: WorkbenchCfg;
  salvage: SalvageRecipeCfg;
  furnace: FurnaceRecipeCfg;
  sorting: SortingRecipeCfg;
  alchemy: AlchemyCfg;
  builders: BuilderRecipeCfg;
};
type RecipeItem<K extends RecipeType = RecipeType> = HasId & HasRecipes<K>;
export type HasRecipes<K extends keyof RecipeCfg = keyof RecipeCfg> = {
  [P in K]?: RecipeCfg[P];
};

const recipeData: {
  [K in RecipeType]: (prefix: string, item: RecipeItem<K>) => RecipeData[K];
} = {
  workbench: (prefix, item) => ({
    id: item.id,
    categories: item.workbench?.categories ?? ["Workbench_Tinkering"],
    input: item.workbench?.input ?? [prefix + item.id],
    output: item.workbench?.output ?? item.id,
    time: item.workbench?.time ?? 14
  }),
  sorting: (prefix, item) => ({
    id: item.id,
    input: item.sorting?.input ?? `6x ${prefix + item.id}`,
    output: item.sorting?.output ?? [""],
    time: item.sorting?.time ?? 14
  }),
  salvage: (prefix, item) => ({
    id: item.id,
    input: item.salvage?.input ?? prefix + item.id,
    output: item.salvage?.output ?? [""],
    time: item.salvage?.time ?? 4
  }),
  furnace: (prefix, item) => ({
    id: item.id,
    input: item.furnace?.input ?? prefix + item.id,
    output: item.furnace?.output ?? "",
    time: item.furnace?.time ?? 1
  }),
  alchemy: (prefix, item) => ({
    id: item.id,
    categories: item.alchemy?.categories ?? ["Alchemy_Potions_Misc"],
    input: item.alchemy?.input ?? [prefix + item.id],
    output: item.alchemy?.output ?? "",
    time: item.alchemy?.time ?? 14
  }),
  builders: (prefix, item) => ({
    id: item.id,
    input: item.builders?.input ?? prefix + item.id,
    output: item.builders?.output ?? ""
  })
};

export function recipes<T extends RecipeItem>(prefix: string, cfgs: Flatten<T>) {
  const cfgsFlat = flatten(cfgs);
  const grouped: { [K in RecipeType]: RecipeData[K][] } = {
    workbench: [],
    salvage: [],
    furnace: [],
    sorting: [],
    alchemy: [],
    builders: []
  };

  for (const cfg of cfgsFlat) {
    if (cfg.salvage) grouped.salvage.push(recipeData.salvage(prefix, cfg));
    if (cfg.furnace) grouped.furnace.push(recipeData.furnace(prefix, cfg));
    if (cfg.sorting) grouped.sorting.push(recipeData.sorting(prefix, cfg));
    if (cfg.alchemy) grouped.alchemy.push(recipeData.alchemy(prefix, cfg));
    if (cfg.builders) grouped.builders.push(recipeData.builders(prefix, cfg));
  }

  if (grouped.salvage.length) salvage.many(grouped.salvage).build();
  if (grouped.furnace.length) furnace.many(grouped.furnace).build();
  if (grouped.sorting.length) sorting.many(grouped.sorting).build();
  if (grouped.alchemy.length) alchemy.many(grouped.alchemy).build();
  if (grouped.builders.length) builders.many(grouped.builders).build();
}

export const hasId = <T extends { id?: string }>(value: T): value is T & { id: string } => typeof value.id === "string";

export const hasColor = <T extends { color?: string }>(value: T): value is T & { color: string } =>
  typeof value.color === "string";


