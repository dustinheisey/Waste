import { categories, setGlobal, syncPublic } from "hytale-generators";
import { generateBenches } from "./src/benches.ts";
import { generateTreasures } from "./src/ingredients/treasures.ts";
import { generateWasteBlocks } from "./src/waste-blocks.ts";
import { generateBars } from "./src/ingredients/bars.ts";
import { generateFabrics } from "./src/ingredients/fabrics.ts";
import { generateDusts } from "./src/ingredients/dusts.ts";
import { generateWastes } from "./src/ingredients/wastes.ts";
import { generateScrap } from "./src/ingredients/scrap.ts";
import { generateBuildingBlocks } from "./src/building.ts";

setGlobal({ modId: "Waste", outDir: "../main/resources" });

syncPublic();

categories(["Wastes", "Treasures", "Materials", "Tools"]);

generateWasteBlocks();
generateWastes();
generateFabrics();
generateDusts();
generateBars();
// generateScrap();
generateTreasures();
generateBenches();
// generateBuildingBlocks();
