import {setGlobal, syncPublic} from "hytale-generators";
import {registerCategories} from "./collections/categories.ts";
import {registerBenches} from "./collections/benches.ts";
import {registerBuildingBlocks} from "./collections/building.ts";
import {registerFibers} from "./collections/fibers.ts";
import {registerMetals} from "./collections/metals.ts";
import {registerTreasures} from "./collections/treasures.ts";
import {registerWastes} from "./collections/waste.ts";

setGlobal({modId: "Waste", outDir: "../main/resources"});
syncPublic();

registerCategories();
registerBenches();
registerBuildingBlocks();
registerFibers();
registerMetals();
registerTreasures();
registerWastes();
