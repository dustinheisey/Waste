import { setGlobal, syncPublic } from "hytale-generators";
import { registerBars } from "./collections/bars.ts";
import { registerBenches } from "./collections/benches.ts";
import { registerBlocks } from "./collections/blocks.ts";
import { registerCategories } from "./collections/categories.ts";
import { registerDusts } from "./collections/dusts.ts";
import { registerScraps } from "./collections/scraps.ts";
import { registerTreasures } from "./collections/treasures.ts";
import { registerWasteBlocks } from "./collections/waste-blocks.ts";
import { registerWastes } from "./collections/wastes.ts";

setGlobal({
  modId: "Waste",
  outDir: "../main/resources"
});

syncPublic();

registerCategories();
registerWasteBlocks();
registerWastes();
registerScraps();
registerTreasures();
registerDusts();
registerBars();
registerBenches();
registerBlocks();
