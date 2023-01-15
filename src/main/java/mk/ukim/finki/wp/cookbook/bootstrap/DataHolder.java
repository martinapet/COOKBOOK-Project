package mk.ukim.finki.wp.cookbook.bootstrap;

import lombok.Getter;
import mk.ukim.finki.wp.cookbook.model.*;
import mk.ukim.finki.wp.cookbook.repository.jpa.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Component
@Getter
public class DataHolder {
    public static final List<Ingredient> ingredients = new ArrayList<>();
    public static final List<Recipe> recipes = new ArrayList<>();
    public static final List<Instruction> instructions = new ArrayList<>();
    public static final List<Image> images = new ArrayList<>();
    public static final List<Pair> pairs = new ArrayList<>();

    IngredientRepository ingredientRepository;
    InstructionRepository instructionRepository;
    RecipeRepository recipeRepository;
    ImageRepository imageRepository;
    PairRepository pairRepository;

    public DataHolder(IngredientRepository ingredientRepository, InstructionRepository instructionRepository,
                      RecipeRepository recipeRepository,
                      ImageRepository imageRepository,
                      PairRepository pairRepository) {
        this.ingredientRepository = ingredientRepository;
        this.recipeRepository = recipeRepository;
        this.instructionRepository = instructionRepository;
        this.imageRepository = imageRepository;
        this.pairRepository = pairRepository;
    }

    @PostConstruct
    public void init() {
        // "Banana Cream Pie Smoothie",
        List<Ingredient> ingredients1 = new ArrayList<>();
        ingredients1.add(new Ingredient("1 whole Vanilla Wafer Cookie"));
        ingredients1.add(new Ingredient("1- 1/2 whole Peeled Bananas, Frozen"));
        ingredients1.add(new Ingredient("2 cups Coconut Milk, Unsweetened From Carton"));
        ingredients1.add(new Ingredient("2 Tablespoons Fat-free Half-and-half"));
        ingredients1.add(new Ingredient("1 Tablespoon Vanilla Extract"));
        ingredients1.add(new Ingredient("1/2 teaspoons Stevia (more To Taste)"));
        ingredients1.add(new Ingredient("1 cup Ice Cubes"));
        ingredients1.add(new Ingredient("4 Tablespoons Whipped Cream"));
        ingredients.addAll(ingredients1);
        List<Instruction> instructions1 = new ArrayList<>();
        instructions1.add(new Instruction("Place vanilla wafer cookie in a baggie, seal bag and crush it into tiny pieces (I rolled a rolling pin over it)."));
        instructions1.add(new Instruction("Set aside."));
        instructions1.add(new Instruction("In a blender add banana, coconut milk, half-and-half, vanilla extract, stevia and ice cubes."));
        instructions1.add(new Instruction("Put the lid on and blend until smooth."));
        instructions1.add(new Instruction("Pour into 2 cups and top each smoothie with whipped cream and crushed wafer cookie."));
        instructions.addAll(instructions1);
        recipes.add(new Recipe("00016355e6", "Banana Cream Pie Smoothie", "http://tastykitchen.com/recipes/drinks/banana-cream-pie-smoothie/", "train", ingredients1, instructions1));
        List<Pair> pairs1 = new ArrayList<>();
        pairs1.add(new Pair("fbb388415c.jpg", "http:\\/\\/tastykitchen.com\\/recipes\\/wp-content\\/uploads\\/sites\\/2\\/2013\\/09\\/Banana-Cream-Pie-Smoothie-410x291.jpg"));
        pairs.addAll(pairs1);
        images.add(new Image("00016355e6", pairs1));

        //Crunchy onion potato bake---
        List<Ingredient> ingredients2 = new ArrayList<>();
        ingredients2.add(new Ingredient("2 12 cups milk"));
        ingredients2.add(new Ingredient("1 12 cups water"));
        ingredients2.add(new Ingredient("14 cup butter"));
        ingredients2.add(new Ingredient("mashed potatoes, 1 box, homestyle"));
        ingredients2.add(new Ingredient("1 (8 ounce) can whole kernel corn (drained)"));
        ingredients2.add(new Ingredient("1 cup cheddar cheese"));
        ingredients2.add(new Ingredient("1 cup French-fried onions"));
        ingredients.addAll(ingredients2);
        List<Instruction> instructions2 = new ArrayList<>();
        instructions2.add(new Instruction("Preheat oven to 350 degrees Fahrenheit."));
        instructions2.add(new Instruction("Spray pan with non stick cooking spray."));
        instructions2.add(new Instruction("Heat milk, water and butter to boiling; stir in contents of both pouches of potatoes; let stand one minute."));
        instructions2.add(new Instruction("Stir in corn."));
        instructions2.add(new Instruction("Spoon half the potato mixture in pan."));
        instructions2.add(new Instruction("Sprinkle half each of cheese and onions; top with remaining potatoes."));
        instructions2.add(new Instruction("Sprinkle with remaining cheese and onions."));
        instructions2.add(new Instruction("Bake 10 to 15 minutes until cheese is melted."));
        instructions2.add(new Instruction("Enjoy !"));
        instructions.addAll(instructions2);
        recipes.add(new Recipe("00003a70b1", "Crunchy Onion Potato Bake", "http://www.food.com/recipe/crunchy-onion-potato-bake-479149", "test", ingredients2, instructions2));
        List<Pair> pairs2 = new ArrayList<>();
        pairs2.add(new Pair("3e233001e2.jpg", "https://www.thespruceeats.com/thmb/i6MO6_7bgHIzM2at0f6lHHfeTN0=/960x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/porkchophashbrownbake225-569fe2ba3df78cafda9eed61.jpg"));
        pairs.addAll(pairs2);
        images.add(new Image("00003a70b1", pairs2));


        //Kombu Tea Grilled Chicken Thigh ---
        List<Ingredient> ingredients3 = new ArrayList<>();
        ingredients3.add(new Ingredient("2 Chicken thighs"));
        ingredients3.add(new Ingredient("2 tsp Kombu tea"));
        ingredients3.add(new Ingredient("1 White pepper"));
        ingredients.addAll(ingredients3);
        List<Instruction> instructions3 = new ArrayList<>();
        instructions3.add(new Instruction("Pierce the skin of the chicken with a fork or knife."));
        instructions3.add(new Instruction("Sprinkle with kombu tea evenly on both sides of the chicken, about 1 teaspoon per chicken thigh."));
        instructions3.add(new Instruction("Brown the skin side of the chicken first over high heat until golden brown."));
        instructions3.add(new Instruction("Sprinkle some pepper on the meat just before flipping over."));
        instructions3.add(new Instruction("Then brown the other side until golden brown."));
        instructions.addAll(instructions3);
        recipes.add(new Recipe("000075604a", "Kombu Tea Grilled Chicken Thigh", "https://cookpad.com/us/recipes/150100-kombu-tea-grilled-chicken-thigh", "train", ingredients3, instructions3));
        List<Pair> pairs3 = new ArrayList<>();
        pairs3.add(new Pair("6bdca6e490.jpg", "https://www.japanesecooking101.com/wp-content/uploads/2013/07/DSC01676copy-1024x682.jpg"));
        pairs.addAll(pairs3);
        images.add(new Image("000075604a", pairs3));

        //Fennel-Rubbed Pork Tenderloin with Roasted Fennel Wedges ---
        List<Ingredient> ingredients5 = new ArrayList<>();
        ingredients5.add(new Ingredient("1 teaspoon fennel seeds"));
        ingredients5.add(new Ingredient("1 pound pork tenderloin"));
        ingredients5.add(new Ingredient("2 medium fennel bulbs, trimmed, reserving fronds"));
        ingredients5.add(new Ingredient("2 tablespoons extra-virgin olive oil"));
        ingredients5.add(new Ingredient("3 garlic cloves, smashed"));
        ingredients5.add(new Ingredient("1/4 cup dry white wine"));
        ingredients5.add(new Ingredient("1/2 cup reduced-sodium chicken broth"));
        ingredients5.add(new Ingredient("2 tablespoons unsalted butter, cut into pieces"));
        ingredients5.add(new Ingredient("1/2 teaspoon fresh lemon juice, or to taste"));
        ingredients.addAll(ingredients5);
        List<Instruction> instruction5=new ArrayList<>();
        instruction5.add(new Instruction("Preheat oven to 350F with rack in middle."));
        instruction5.add(new Instruction("Crush fennel seeds with a mortar and pestle or wrap in a kitchen towel and crush with bottom of a heavy skillet."));
        instruction5.add(new Instruction("Pat pork dry, then sprinkle with crushed fennel seeds and 1/2 teaspoon each of salt and pepper."));
        instruction5.add(new Instruction("Cut fennel bulbs lengthwise into 1/2-inch wedges."));
        instruction5.add(new Instruction("Heat oil in a 12-inch oven-proof heavy skillet over medium-high heat until it shimmers."));
        instruction5.add(new Instruction("Brown pork on all sides, about 6 minutes total, then transfer to a plate."));
        instruction5.add(new Instruction("Saute garlic and fennel wedges in skillet until fennel is golden brown, about 6 minutes."));
        instruction5.add(new Instruction("Add wine, stirring and scraping up brown bits, then stir in broth and butter."));
        instruction5.add(new Instruction("Put pork on top of fennel and transfer skillet to oven."));
        instruction5.add(new Instruction("Roast until an instant-read thermometer inserted into center of pork registers 145 to 150F, about 15 minutes."));
        instruction5.add(new Instruction("Transfer pork to a cutting board and let rest 10 minutes."));
        instruction5.add(new Instruction("Meanwhile, transfer skillet to stovetop (handle will be hot) and boil, stirring occasionally, until most of liquid has evaporated."));
        instruction5.add(new Instruction("Stir in lemon juice and 1/4 cup chopped fennel fronds."));
        instruction5.add(new Instruction("Thinly slice pork and serve over fennel with sauce."));
        instructions.addAll(instruction5);
        recipes.add(new Recipe("0000b1e2b5","Fennel-Rubbed Pork Tenderloin with Roasted Fennel Wedges","http://www.epicurious.com/recipes/food/views/fennel-rubbed-pork-tenderloin-with-roasted-fennel-wedges-351294" ,"train",ingredients5,instruction5));
        List<Pair> pairs5 = new ArrayList<>();
        pairs5.add(new Pair("cb1a684683.jpg ", " http://assets.epicurious.com/photos/5609a4d662fa7a9917c25748/master/pass/351294_hires.jpg"));
        pairs.addAll(pairs5);
        images.add(new Image("0000b1e2b5",pairs5));

        //Sausage and marmalade plait recipe ---
        List<Ingredient> ingredients9 = new ArrayList<>();
        ingredients9.add(new Ingredient("750 g (26.5oz) pork sausage meat"));
        ingredients9.add(new Ingredient("1 onion, finely chopped"));
        ingredients9.add(new Ingredient("1 garlic clove, finely chopped"));
        ingredients9.add(new Ingredient("2 sprigs of thyme, leaves picked and chopped"));
        ingredients9.add(new Ingredient("4 or 5 tsps of marmalade"));
        ingredients9.add(new Ingredient("1 pack of ready rolled puff pastry (375g)"));
        ingredients9.add(new Ingredient("1 egg, beaten"));
        ingredients9.add(new Ingredient("1 tsp of poppy seeds"));
        ingredients9.add(new Ingredient("1 pinch salt and pepper, to season"));
        ingredients9.add(new Ingredient("1 splash of oil or knob of butter, for frying"));
        ingredients.addAll(ingredients9);
        List<Instruction> instructions9 = new ArrayList<>();
        instructions9.add(new Instruction("First preheat your oven to 200C and then place a frying pan on the hob over a medium heat, add your oil or butter and then add the onion and garlic."));
        instructions9.add(new Instruction("Saute until soft and take off the heat and leave to cool,"));
        instructions9.add(new Instruction("Once cool, place the onion and garlic into a bowl, along with the sausage meat and thyme and season well with salt and pepper."));
        instructions9.add(new Instruction("Mix by hand; making sure everything is incorporated well."));
        instructions9.add(new Instruction("Take a large baking tray and unroll the puff pastry over it."));
        instructions9.add(new Instruction("Along the long length of the pastry, place the sausage meat mix evenly in the middle, leaving a gap at either end."));
        instructions9.add(new Instruction("Then using a knife, carve a gully in the centre of the meat."));
        instructions9.add(new Instruction("This is for the marmalade so spoon an even amount in and then carefully press the meat together."));
        instructions9.add(new Instruction("Again with a knife, make slits in the pastry approximately 2 cms apart on either side of the meat and then starting at one end, fold each flap over, creating a plait effect and seal at both ends."));
        instructions9.add(new Instruction("Brush the egg wash all over and scatter the poppy seeds over after that."));
        instructions9.add(new Instruction("Place in the hot oven for 40 45 minutes until the pastry puffs up and browns."));
        instructions9.add(new Instruction("Serve hot or cold."));
        instructions.addAll(instructions9);
        recipes.add(new Recipe("000238353f", "Sausage and marmalade plait recipe", "http://www.lovefood.com/guide/recipes/27146/sausage-and-marmalade-plait-recipe", "train", ingredients9, instructions9));
        List<Pair> pairs9 = new ArrayList<>();
        pairs9.add(new Pair("13e1cc10b7.jpg", "http://www.lovefood.com/images/content/body/plait1.jpg"));
        pairs.addAll(pairs9);
        images.add(new Image("000238353f", pairs9));

       // Apple Carrot Bones (dog treat)---
        List<Ingredient> ingredients10= new ArrayList<>();
        ingredients10.add(new Ingredient("2 1/2 cup wheat flour"));
        ingredients10.add(new Ingredient("1/2 cup rolled oats"));
        ingredients10.add(new Ingredient("1 tbsp brown sugar"));
        ingredients10.add(new Ingredient("2 tbsp dried parsley (optional - helps with bad breath)"));
        ingredients10.add(new Ingredient("1 apple - cored, peeled and grated"));
        ingredients10.add(new Ingredient("2 carrots - peeled and grated"));
        ingredients10.add(new Ingredient("1 egg - beaten"));
        ingredients10.add(new Ingredient("1/3 cup vegetable oil"));
        ingredients10.add(new Ingredient("1/4 1/2 cup of water"));
        ingredients.addAll(ingredients10);
        List<Instruction> instructions10 = new ArrayList<>();
        instructions10.add(new Instruction("Preheat oven to 350F and line baking sheet with parchment paper."));
        instructions10.add(new Instruction("Combine flour, oats, sugar and parsley."));
        instructions10.add(new Instruction("In separate bowl, combine egg, oil, apple and carrot."));
        instructions10.add(new Instruction("Stir flour mixture into egg mixture, slowly adding water and kneading until a dough forms."));
        instructions10.add(new Instruction("If dough is too sticky, add more flour."));
        instructions10.add(new Instruction("Roll dough out on a lightly floured surface to 1/4\" thick and cut out shapes."));
        instructions10.add(new Instruction("Knead scraps together, roll out, cut out shapes, and repeat until all dough is used."));
        instructions10.add(new Instruction("Place on baking sheet and bake for 40-45 minutes."));
        instructions10.add(new Instruction("Turn oven off and leave in oven for 20 minutes to allow bones to dry out and crisp."));
        instructions.addAll(instructions10);
        recipes.add(new Recipe("00029f71f7", "Apple Carrot Bones (dog treat)", "https://cookpad.com/us/recipes/369091-apple-carrot-bones-dog-treat", "val", ingredients10, instructions10));
        List<Pair> pairs10 = new ArrayList<>();
        pairs10.add(new Pair("665bbeafc7.jpg", "https://i.etsystatic.com/21494181/r/il/c02cfb/2066394378/il_794xN.2066394378_ghjg.jpg"));
        pairs.addAll(pairs10);
        images.add(new Image("00029f71f7", pairs10));

        //Amy's Cheesey , Bacon savory bites  ---
        List<Ingredient> ingredients12= new ArrayList<>();
        ingredients12.add(new Ingredient("1/4 cup butter"));
        ingredients12.add(new Ingredient("1 egg"));
        ingredients12.add(new Ingredient("1/4 cup tograted cheese - i used colby cheese"));
        ingredients12.add(new Ingredient("1 a good cracking of cracked pepper)"));
        ingredients12.add(new Ingredient("1 a good cracking of rock salt"));
        ingredients12.add(new Ingredient("1/2 tsp curry powder"));
        ingredients12.add(new Ingredient("1 cup plain flour"));
        ingredients12.add(new Ingredient("1/4 cup grated cheese - roughly - for topping before cooking"));
        ingredients12.add(new Ingredient("1/3 cup vegetable oil"));
        ingredients.addAll(ingredients12);
        List<Instruction> instructions12 = new ArrayList<>();
        instructions12.add(new Instruction("preheat oven to 190'C - 375'F."));
        instructions12.add(new Instruction("lightly grease an oven tray and set aside till needed ."));
        instructions12.add(new Instruction("dice and cook bacon or ham , drain and set aside till needed ."));
        instructions12.add(new Instruction("in a bowl ."));
        instructions12.add(new Instruction("beat butter until light and creamy ."));
        instructions12.add(new Instruction("then add the egg and combine well , next add the cracked pepper , salt and the curry powder and stir to combine , now add the first quarter cup of cheese and half the diced cooked bacon and mix well to combine all ."));
        instructions12.add(new Instruction("add the sifted plain flour to the mix and mix to a smooth dough , cover and refrigerate for about half hour ."));
        instructions12.add(new Instruction("remove dough from the fridge and roll out on a lightly floured surface to about 1cm thickness ."));
        instructions12.add(new Instruction("with a small round cutter , cut out biscuit shapes and set on prepared tray ."));
        instructions12.add(new Instruction("add bits of the other quarter cup of grated cheese on top of biscuits , i then like to crack a little more pepper over the cheeses then sprinkle with the other half of the bacon bits"));
        instructions12.add(new Instruction("place in oven and cook for about 12-15 minutes or until slightly golden and cheese and bacon have crispened up and melted ."));
        instructions12.add(new Instruction("remove from heat let cool a little and eat hot or cold , they are great either way ."));
        instructions12.add(new Instruction("enjoy ."));
        instructions12.add(new Instruction(":-)"));
        instructions.addAll(instructions12);
        recipes.add(new Recipe("00033f624d", "Amy's Cheesey , Bacon savory bites", "https://cookpad.com/us/recipes/334475-amys-cheesey-bacon-savory-bites", "train", ingredients12, instructions12));
        List<Pair> pairs12 = new ArrayList<>();
        pairs12.add(new Pair("ccfd7a7e7e.jpg", "https://img-global.cpcdn.com/001_recipes/4558674072698880/0x0/photo.jpg"));
        pairs.addAll(pairs12);
        images.add(new Image("00033f624d", pairs12));

        // Worlds Best Mac and Cheese
        List<Ingredient> ingredients13 = new ArrayList<>();
        ingredients13.add(new Ingredient("6 ounces penne"));
        ingredients13.add(new Ingredient("2 cups Beechers Flagship Cheese Sauce (recipe follows)"));
        ingredients13.add(new Ingredient("1 ounce Cheddar, grated (1/4 cup)"));
        ingredients13.add(new Ingredient("1 ounce Gruyere cheese, grated (1/4 cup)"));
        ingredients13.add(new Ingredient("1/4 to 1/2 teaspoon chipotle chili powder"));
        ingredients13.add(new Ingredient("1/4 cup (1/2 stick) unsalted butter"));
        ingredients13.add(new Ingredient("1/3 cup all-purpose flour"));
        ingredients13.add(new Ingredient("3 cups milk"));
        ingredients13.add(new Ingredient("14 ounces semihard cheese (page 23), grated (about 3 1/2 cups)"));
        ingredients13.add(new Ingredient("2 ounces semisoft cheese (page 23), grated (1/2 cup)"));
        ingredients13.add(new Ingredient("1/2 teaspoon kosher salt"));
        ingredients13.add(new Ingredient("text\": \"1/4 to 1/2 teaspoon chipotle chili powder"));
        ingredients13.add(new Ingredient("1/8 teaspoon garlic powder"));
        ingredients13.add(new Ingredient("\"(makes about 4 cups)\""));
        ingredients.addAll(ingredients13);
        List<Instruction> instructions13 = new ArrayList<>();
        instructions13.add(new Instruction("Preheat the oven to 350 F. Butter or oil an 8-inch baking dish."));
        instructions13.add(new Instruction("Cook the penne 2 minutes less than package directions."));
        instructions13.add(new Instruction("(It will finish cooking in the oven.)"));
        instructions13.add(new Instruction("Rinse the pasta in cold water and set aside."));
        instructions13.add(new Instruction("Combine the cooked pasta and the sauce in a medium bowl and mix carefully but thoroughly."));
        instructions13.add(new Instruction("Scrape the pasta into the prepared baking dish."));
        instructions13.add(new Instruction("Bake, uncovered, for 20 minutes."));
        instructions13.add(new Instruction("Let the mac and cheese sit for 5 minutes before serving."));
        instructions13.add(new Instruction("Melt the butter in a heavy-bottomed saucepan over medium heat and whisk in the flour."));
        instructions13.add(new Instruction("Continue whisking and cooking for 2 minutes."));
        instructions13.add(new Instruction("Slowly add the milk, whisking constantly."));
        instructions13.add(new Instruction("Cook until the sauce thickens, about 10 minutes, stirring frequently."));
        instructions13.add(new Instruction("Remove from the heat. Add the cheeses, salt, chili powder, and garlic powder."));
        instructions13.add(new Instruction("Stir until the cheese is melted and all ingredients are incorporated, about 3 minutes."));
        instructions13.add(new Instruction("Use immediately, or refrigerate for up to 3 days."));
        instructions13.add(new Instruction("Slowly add the milk, whisking constantly."));
        instructions13.add(new Instruction("CThis sauce reheats nicely on the stove in a saucepan over low heat."));
        instructions13.add(new Instruction("Stir frequently so the sauce doesnt scorch."));
        instructions13.add(new Instruction("Use immediately, or refrigerate for up to 3 days."));
        instructions13.add(new Instruction("Slowly add the milk, whisking constantly."));
        instructions13.add(new Instruction("One-half teaspoon of chipotle chili powder makes a spicy mac, so make sure your family and friends can handle it!"));
        instructions.addAll(instructions13);
        recipes.add(new Recipe("000018c8a5", "Worlds Best Mac and Cheese", "http://www.epicurious.com/recipes/food/views/-world-s-best-mac-and-cheese-387747", "train", ingredients13, instructions13));
        List<Pair> pairs13 = new ArrayList<>();
        pairs13.add(new Pair("6bdca6e490.jpg", "https://food.fnr.sndimg.com/content/dam/images/food/fullset/2009/6/12/0/TM1022_30666_s4x3.jpg.rend.hgtvcom.826.620.suffix/1547582576993.jpeg"));
        pairs.addAll(pairs13);
        images.add(new Image("000018c8a5", pairs13));

        // sweet
        //Brown Sugar 'Karintou' Snacks ***
        List<Ingredient> ingredients6 = new ArrayList<>();
        ingredients6.add(new Ingredient("200 grams Cake flour"));
        ingredients6.add(new Ingredient("1 tsp Baking powder"));
        ingredients6.add(new Ingredient("20 grams Sugar"));
        ingredients6.add(new Ingredient("7 grams White sesame seeds"));
        ingredients6.add(new Ingredient("70 ml Water"));
        ingredients6.add(new Ingredient("20 cc Vegetable oil"));
        ingredients6.add(new Ingredient("80 grams For candy coating: black sugar"));
        ingredients6.add(new Ingredient("80 grams For candy coating: white sugar"));
        ingredients6.add(new Ingredient("1/4 tsp For candy coating: soy sauce"));
        ingredients6.add(new Ingredient("40 ml For candy coating: water"));
        ingredients.addAll(ingredients6);
        List<Instruction> instructions6 = new ArrayList<>();
        instructions6.add(new Instruction("In a bowl, mix flour, baking powder, sugar, then add the sesame seeds, water, and vegetable oil and knead."));
        instructions6.add(new Instruction("Once the dough is formed, wrap in plastic wrap and let rise for 30 minutes."));
        instructions6.add(new Instruction("Roll out until it is 1 cm thick."));
        instructions6.add(new Instruction("Then cut to 3 cm long and 1 cm wide strips."));
        instructions6.add(new Instruction("Use your hands roll into tubes."));
        instructions6.add(new Instruction("Deep fry in 160C oil for 10 to 15 minutes."));
        instructions6.add(new Instruction("In a pan, combine the brown sugar, sugar, soy sauce, water and heat until it starts to bubble."));
        instructions6.add(new Instruction("Once the large bubbles change to small bubbles, add the Step 5 karintou to coat."));
        instructions6.add(new Instruction("Spread out on a baking sheet to prevent sticking."));
        instructions6.add(new Instruction("They're done once they're dried."));
        instructions.addAll(instructions6);
        recipes.add(new Recipe("00010379bf", "Brown Sugar 'Karintou' Snacks", "https://cookpad.com/us/recipes/156014-brown-sugar-karintou-snacks", "train", ingredients6, instructions6));
        List<Pair> pairs6 = new ArrayList<>();
        pairs6.add(new Pair("f480145da5.jpg", "https://miro.medium.com/max/1375/1*oZCgAohpRJxfNSvPv34FNw.jpeg"));
        pairs.addAll(pairs6);
        images.add(new Image("00010379bf", pairs6));


        //Tinklee's Vanilla Crack ***
        List<Ingredient> ingredients7 = new ArrayList<>();
        ingredients7.add(new Ingredient("1 box salted soda crackers (I use saltines)"));
        ingredients7.add(new Ingredient("1 cup salted butter"));
        ingredients7.add(new Ingredient("1 cup white granulated sugar"));
        ingredients7.add(new Ingredient("2 tsp vanilla extract"));
        ingredients7.add(new Ingredient("1/2 cup salted nut pieces"));
        ingredients.addAll(ingredients7);
        List<Instruction> instructions7 = new ArrayList<>();
        instructions7.add(new Instruction("preheat oven to 350 degrees F rack in middle position, line a 10 x 15\" cookie sheet with heavy foil (jellyroll pan works great), having the foil go up the sides, spray foil with cooking sray"));
        instructions7.add(new Instruction("cover the bottom of the cookie sheet with a single layer of soda crackers, salt side up, ( you can break them in to smaller pieces to fit if you have to, set cracker lined pan aside"));
        instructions7.add(new Instruction("combine butter, white sugar and vanilla in a heavy sauce pan, bring to a full boil over medium high heat stirring constantly, ( a full boil will have breaking bubbles all over the surface of the pan) boil it for exactly 5 minutes, stirring constantly"));
        instructions7.add(new Instruction("when times up, pour mixture carefully over the soda crackers as evenly as you can, sprinkle the salted nut pieces over the top,"));
        instructions7.add(new Instruction("slide the pan into the oven to bake for 10 minutes, remove the pan from the oven and let it cool on a wire rack, when cookies have cooled all the way, peel off the foil backing and break into ramdom size pieces"));
        instructions.addAll(instructions7);
        recipes.add(new Recipe("00013266c9", "Tinklee's Vanilla Crack", "https://cookpad.com/us/recipes/345321-tinklees-vanilla-crack", "train", ingredients7, instructions7));
        List<Pair> pairs7 = new ArrayList<>();
        pairs7.add(new Pair("4636c7f576.jpg", "https://i.pinimg.com/400x300/2e/f8/2c/2ef82cdcfe786fb02558fb86831cc272.jpg"));
        pairs.addAll(pairs7);
        images.add(new Image("00013266c9", pairs7));

        //Cooked Raspberry Jelly - CERTO Crystals***
        List<Ingredient> ingredients8 = new ArrayList<>();
        ingredients8.add(new Ingredient("4 cups prepared juice (buy about 10 cups raspberries)"));
        ingredients8.add(new Ingredient("1 box Certo Pectin Crystals"));
        ingredients8.add(new Ingredient("5-1/2 cups granulated sugar"));
        ingredients.addAll(ingredients8);
        List<Instruction> instructions8 = new ArrayList<>();
        instructions8.add(new Instruction("Crush raspberries, one layer at a time."));
        instructions8.add(new Instruction("Place prepared raspberries in jelly bag; hang and let drip into bowl until dripping stops."));
        instructions8.add(new Instruction("Press bag gently to remove any remaining juices."));
        instructions8.add(new Instruction("Measure exactly 4 cups prepared juice into large saucepan."));
        instructions8.add(new Instruction("Stir in pectin."));
        instructions8.add(new Instruction("Bring to boil on high heat."));
        instructions8.add(new Instruction("Stir in sugar."));
        instructions8.add(new Instruction("Return to boil; cook 1 min."));
        instructions8.add(new Instruction("Remove from heat."));
        instructions8.add(new Instruction("Stir and skim 5 min."));
        instructions8.add(new Instruction("Pour into warm sterilized jars, filling up to 1/4 inch from rims."));
        instructions8.add(new Instruction("Cover with lids."));
        instructions8.add(new Instruction("Let stand at room temperature 24 hours or until set."));
        instructions.addAll(instructions8);
        recipes.add(new Recipe("00018371f2", "Cooked Raspberry Jelly - CERTO Crystals", "http://www.kraftrecipes.com/recipes/cooked-raspberry-jelly-certo-crystals-182098.aspx", "train", ingredients8, instructions8));
        List<Pair> pairs8 = new ArrayList<>();
        pairs8.add(new Pair("4247c11be3.jpg", "http://assets.kraftfoods.com/recipe_images/182098-182099.jpg"));
        pairs.addAll(pairs8);
        images.add(new Image("00018371f2", pairs8));

        //Popcorn Trail Mix ***
        List<Ingredient> ingredients11 = new ArrayList<>();
        ingredients11.add(new Ingredient("1 pkg. (1.06 oz.) fudge-drizzled caramel popcorn"));
        ingredients11.add(new Ingredient("1/4 cup PLANTERS NUTrition Digestive Health Mix"));
        ingredients.addAll(ingredients11);
        List<Instruction> instructions11 = new ArrayList<>();
        instructions11.add(new Instruction("Combine ingredients."));
        instructions.addAll(instructions11);
        recipes.add(new Recipe("0002a82634", "Popcorn Trail Mix", "http://www.kraftrecipes.com/recipes/popcorn-trail-mix-127897.aspx", "train", ingredients11, instructions11));
        List<Pair> pairs11 = new ArrayList<>();
        pairs11.add(new Pair("6f50459f10.jpg", "http://assets.kraftfoods.com/recipe_images/Popcorn-Trail-Mix-61178.jpg"));
        pairs.addAll(pairs11);
        images.add(new Image("0002a82634", pairs11));

        //Super Easy Pie Crust ***
        List<Ingredient> ingredients15 = new ArrayList<>();
        ingredients15.add(new Ingredient("1- 1/2 cup All-purpose Flour"));
        ingredients15.add(new Ingredient("1 Tablespoon White Sugar"));
        ingredients15.add(new Ingredient("1/2 teaspoons Salt"));
        ingredients15.add(new Ingredient("1/2 cups Vegetable Oil"));
        ingredients15.add(new Ingredient("2 Tablespoons Milk"));
        ingredients.addAll(ingredients15);
        List<Instruction> instructions15 = new ArrayList<>();
        instructions15.add(new Instruction("If not filling the crust, preheat oven to 400 degrees."));
        instructions15.add(new Instruction("If you're going to fill the crust, follow your recipe directions, add the filling, and baking accordingly."));
        instructions15.add(new Instruction("Place all the ingredients into a 9 pie pan."));
        instructions15.add(new Instruction("Stir together with a fork."));
        instructions15.add(new Instruction("Pat the mixture into the bottom and up the sides of the pan."));
        instructions15.add(new Instruction("Poke holes into the bottom and sides of the crust (if you are not filling it"));
        instructions15.add(new Instruction("Bake for 15 minutes in a preheated oven or until golden brown."));
        instructions15.add(new Instruction("Fill as desired!"));
        instructions15.add(new Instruction("(I used this recipe to make a pumpkin pie, filling and baking it."));
        instructions15.add(new Instruction("It came out great!"));
        instructions.addAll(instructions15);
        recipes.add(new Recipe("0004073370", "Super Easy Pie Crust", "http://tastykitchen.com/recipes/desserts/super-easy-pie-crust-2/", "train", ingredients15, instructions15));
        List<Pair> pairs15 = new ArrayList<>();
        pairs15.add(new Pair("40e540fa0e.jpg", "https://www.tasteofhome.com/wp-content/uploads/2018/01/Easy-Pie-Crust_EXPS_FT19_31373_F_0716_1-1-696x696.jpg"));
        pairs.addAll(pairs15);
        images.add(new Image("0004073370", pairs15));



        //Mummy Cupcakes ***
        List<Ingredient> ingredients16 = new ArrayList<>();
        ingredients16.add(new Ingredient("1 pkg. (2-layer size) chocolate cake mix"));
        ingredients16.add(new Ingredient("14 Oreo Cookies, coarsely chopped"));
        ingredients16.add(new Ingredient("1 pkg. (4-serving size) Jell-O Vanilla Instant Pudding"));
        ingredients16.add(new Ingredient("1 cup cold milk"));
        ingredients16.add(new Ingredient("1/4 cup icing sugar"));
        ingredients16.add(new Ingredient("2 cups thawed Cool Whip Whipped Topping"));
        ingredients16.add(new Ingredient("48 Baker's Semi-Sweet Chocolate Chips"));
        ingredients.addAll(ingredients16);
        List<Instruction> instructions16 = new ArrayList<>();
        instructions16.add(new Instruction("Heat oven to 350F."));
        instructions16.add(new Instruction("Prepare cake batter as directed on package; stir in cookies."));
        instructions16.add(new Instruction("Spoon into 24 paper-lined muffin cups."));
        instructions16.add(new Instruction("Bake 20 to 25 min."));
        instructions16.add(new Instruction("or until toothpick inserted in centres comes out clean."));
        instructions16.add(new Instruction("Cool cupcakes in pans 10 min."));
        instructions16.add(new Instruction("; remove to wire racks."));
        instructions16.add(new Instruction("Cool completely."));
        instructions16.add(new Instruction("Beat pudding mix, milk and sugar in large bowl whisk 2 min., stir in Cool Whip."));
        instructions16.add(new Instruction("Spoon into pastry bag fitted with basket-weave tip."));
        instructions16.add(new Instruction("Pipe pudding mixture onto tops of cupcakes."));
        instructions16.add(new Instruction("Add chocolate chips for the eyes."));
        instructions16.add(new Instruction("Keep refrigerated."));
        instructions.addAll(instructions16);
        recipes.add(new Recipe("00043c736b", "Mummy Cupcakes", "http://www.kraftrecipes.com/recipes/mummy-cupcakes-127461.aspx", "train", ingredients16, instructions16));
        List<Pair> pairs16 = new ArrayList<>();
        pairs16.add(new Pair("ecac2e27b2.jpg", "http://assets.kraftfoods.com/recipe_images/Mummy-Cupcakes-51857.jpg"));
        pairs.addAll(pairs16);
        images.add(new Image("00043c736b", pairs16));

        //fit
        //Yogurt Parfaits***
        List<Ingredient> ingredients4 = new ArrayList<>();
        ingredients4.add(new Ingredient("8 ounces, weight Light Fat Free Vanilla Yogurt (I Used Activia)"));
        ingredients4.add(new Ingredient("1 cup Fresh Sliced Strawberries"));
        ingredients4.add(new Ingredient("1/4 cups Low-fat Granola"));
        ingredients.addAll(ingredients4);
        List<Instruction> instructions4 = new ArrayList<>();
        instructions4.add(new Instruction("Layer all ingredients in a serving dish."));
        instructions.addAll(instructions4);
        recipes.add(new Recipe("000095fc1d", "Yogurt Parfaits", "http://tastykitchen.com/recipes/breakfastbrunch/yogurt-parfaits/", "train", ingredients4, instructions4));
        List<Pair> pairs4 = new ArrayList<>();
        pairs4.add(new Pair("a1374cdd98.jpg", "http://tastykitchen.com/recipes/wp-content/uploads/sites/2/2011/06/IMG_2692-630x420-410x615.jpg"));
        pairs.addAll(pairs4);
        images.add(new Image("000095fc1d", pairs4));

        //Halloween Ghost Pumpkin Character For Bentos ***

        List<Ingredient> ingredients19 = new ArrayList<>();
        ingredients19.add(new Ingredient("1 Kabocha squash"));
        ingredients19.add(new Ingredient("1 dash Sugar"));
        ingredients19.add(new Ingredient("2 1 dash Cucumber"));
        ingredients.addAll(ingredients19);
        List<Instruction> instructions19 = new ArrayList<>();
        instructions19.add(new Instruction("Peel the kabocha squash, and cut into 2 cm pieces, so that it cooks faster in the microwave."));
        instructions19.add(new Instruction("Wrap the kabocha squash in plastic film and microwave."));
        instructions19.add(new Instruction("If a bamboo skewer goes through easily, it's done."));
        instructions19.add(new Instruction("The microwaving time varies depending on your microwave oven."));
        instructions19.add(new Instruction("Make sure not to let the kabocha squash get too dried out."));
        instructions19.add(new Instruction("You can boil the pieces too, but they may get too watery and hard to form."));
        instructions19.add(new Instruction("If you have time, you can try steaming."));
        instructions19.add(new Instruction("Add sugar to the kabocha squash and mix (make it as sweet as you like)."));
        instructions19.add(new Instruction("When the kabocha squash has cooled down, form into a pumpkin shaped ball in plastic wrap."));
        instructions19.add(new Instruction("You can let them rest overnight."));
        instructions19.add(new Instruction("Cut a piece of cucumber to look like the pumpkin stem."));
        instructions19.add(new Instruction("Make the face with nori seaweed - 3 triangles and the mouth."));
        instructions19.add(new Instruction("Put the face on the pumpkin ball."));
        instructions19.add(new Instruction("An example of how to use the pumpkin ball."));
        instructions19.add(new Instruction("I used it for a Hello Kitty themed charaben."));
        instructions.addAll(instructions19);
        recipes.add(new Recipe("003cb1b3fe", "Halloween Ghost Pumpkin Character For Bentos", "https://cookpad.com/us/recipes/168065-halloween-ghost-pumpkin-character-for-bentos", "val", ingredients19, instructions19));
        List<Pair> pairs19 = new ArrayList<>();
        pairs19.add(new Pair("716174be56.jpg", "https://img-global.cpcdn.com/001_recipes/5474951883653120/0x0/photo.jpg"));
        pairs.addAll(pairs19);
        images.add(new Image("003cb1b3fe", pairs19));


        //Perfect Diner Pancakes ***
        List<Ingredient> ingredients14 = new ArrayList<>();
        ingredients14.add(new Ingredient("1 cup All-purpose Flour"));
        ingredients14.add(new Ingredient("3/4 teaspoons Salt"));
        ingredients14.add(new Ingredient("1- 1/2 teaspoon Baking Powder"));
        ingredients14.add(new Ingredient("1/4 teaspoons Baking Soda"));
        ingredients14.add(new Ingredient("3/4 cups Milk"));
        ingredients14.add(new Ingredient("1 whole Extra Large Egg"));
        ingredients14.add(new Ingredient("1 teaspoon Vanilla Bean Paste Or Extract"));
        ingredients14.add(new Ingredient("3 Tablespoons Melted Butter"));
        ingredients.addAll(ingredients14);
        List<Instruction> instructions14 = new ArrayList<>();
        instructions14.add(new Instruction("Heat the griddle (or non-stick skillet) to medium-high."));
        instructions14.add(new Instruction("In a bowl, add all the dry ingredients and whisk to blend."));
        instructions14.add(new Instruction("In a smaller bowl, whisk the milk, egg, and vanilla until frothy."));
        instructions14.add(new Instruction("Add the milk mixture to the dry mix and whisk until smooth."));
        instructions14.add(new Instruction("Finally, whisk in the melted butter."));
        instructions14.add(new Instruction("Allow the pancake batter to rest for 3-5 minutes to thicken."));
        instructions14.add(new Instruction("Start by making one pancake as a test-batch to ensure your heat in accurate."));
        instructions14.add(new Instruction("Use a 1/4 -1/3 cup scoop to ladle the batter onto the griddle."));
        instructions14.add(new Instruction("Cook for 1-3 minutes per side."));
        instructions14.add(new Instruction("Flip when small bubbles rise to the top of the batter."));
        instructions14.add(new Instruction("If your batter thickens too much, add 1-2 tablespoons of milk to thin it just enough to pour."));
        instructions14.add(new Instruction("Makes 8-10 pancakes."));
        instructions.addAll(instructions14);
        recipes.add(new Recipe("003d5f4dea", "Perfect Diner Pancakes", "http://tastykitchen.com/recipes/breakfastbrunch/pancakeswaffles/perfect-diner-pancakes/", "train", ingredients14, instructions14));
        List<Pair> pairs14 = new ArrayList<>();
        pairs14.add(new Pair("457add7494.jpg", "http://tastykitchen.com/recipes/wp-content/uploads/sites/2/2011/06/Perfect-Diner-Pancakes-cropped-410x273.jpg"));
        pairs.addAll(pairs14);
        images.add(new Image("003d5f4dea", pairs14));

        //Butternut Squash Soup or Bisque (Roasting Method) ***
        List<Ingredient> ingredients17 = new ArrayList<>();
        ingredients17.add(new Ingredient("1 small butternut squash, peeled, diced (about 5 C.)"));
        ingredients17.add(new Ingredient("1 medium onion, large dice (1 cup)"));
        ingredients17.add(new Ingredient("1 tablespoon olive oil"));
        ingredients17.add(new Ingredient("1 apple, skinned, large dice (1 cup)"));
        ingredients17.add(new Ingredient("48 ounces chicken broth"));
        ingredients17.add(new Ingredient("1 cup half-and-half"));
        ingredients17.add(new Ingredient("2 tablespoons parsley, fresh, chopped"));
        ingredients17.add(new Ingredient("1 tablespoon thyme, fresh, chopped"));
        ingredients17.add(new Ingredient("crouton (optional)"));
        ingredients17.add(new Ingredient("sour cream (optional)"));
        ingredients.addAll(ingredients17);
        List<Instruction> instructions17 = new ArrayList<>();
        instructions17.add(new Instruction("ROASTING: preheat oven to 450."));
        instructions17.add(new Instruction("Peel and dice squash into 1/2 inch pieces (see tip at end)."));
        instructions17.add(new Instruction("Dice onion into 1/2 inch pieces."));
        instructions17.add(new Instruction("Toss squash and onion with olive oil and spread pieces onto a large flat baking pan."));
        instructions17.add(new Instruction("Season with salt and pepper."));
        instructions17.add(new Instruction("Roast for 20 minutes - add diced apple - and continue roasting another 10-20 minutes (30-40 total roasting time)."));
        instructions17.add(new Instruction("Tip: while you are roasting, make some \"cheese toasts\"."));
        instructions17.add(new Instruction("Put some shredded cheese on top of bread rounds (we like gruyere or parmesan)."));
        instructions17.add(new Instruction("Bake 10-15 minutes until crispy."));
        instructions17.add(new Instruction("These cheese toasts are fantastic soup toppers!"));
        instructions17.add(new Instruction("Place roasted mixture into blender with about half the chicken broth; puree (keep hand on lid because hot liquids can cause the top to \"explode\" off with built up steam)."));
        instructions17.add(new Instruction("Add remaining chicken broth, half-and-half, and herbs; puree."));
        instructions17.add(new Instruction("Transfer mixture to saucepan; reheat gently."));
        instructions17.add(new Instruction("Serve with a dollop of sour cream and croutons."));
        instructions17.add(new Instruction("TIP: to prepare squash, first cut squash in half horizontally."));
        instructions17.add(new Instruction("Place flat end onto cutting board to stabilize squash and use a peeler to remove skin."));
        instructions17.add(new Instruction("Remove seeds."));
        instructions17.add(new Instruction("Then cut into lengths, and then into diced pieces."));
        instructions17.add(new Instruction("NOTE: if you have leftover mashed potatoes from Thanksgiving, add about 1/2 cup, which will thicken the soup and add a nice smoothness."));
        instructions.addAll(instructions17);
        recipes.add(new Recipe("00047059be", "Butternut Squash Soup or Bisque (Roasting Method)", "http://www.food.com/recipe/butternut-squash-soup-or-bisque-roasting-method-26092", "test", ingredients17, instructions17));
        List<Pair> pairs17 = new ArrayList<>();
        pairs17.add(new Pair(" 1657f23729.jpg ", "http://img.sndimg.com/food/image/upload/w_512,h_512,c_fit,fl_progressive,q_95/v1/img/recipes/26/09/29/piclnaUDO.jpg "));
        pairs.addAll(pairs17);
        images.add(new Image("00047059be", pairs17));

        //Peanut Butter & Jelly Pie***
        List<Ingredient> ingredients18 = new ArrayList<>();
        ingredients18.add(new Ingredient("1 (6 oz.) ready-to-use graham cracker crumb crust"));
        ingredients18.add(new Ingredient("1/2 cup seedless raspberry preserves"));
        ingredients18.add(new Ingredient("1 pkg. (8 oz.) PHILADELPHIA Cream Cheese"));
        ingredients18.add(new Ingredient("1/2 cup creamy peanut butter"));
        ingredients18.add(new Ingredient("3/4 cup brown sugar"));
        ingredients18.add(new Ingredient("1-1/2 cups COOL WHIP Whipped Topping, thawed"));
        ingredients18.add(new Ingredient("1/4 cup PLANTERS Dry Roasted Peanuts, chopped"));
        ingredients18.add(new Ingredient("fresh raspberries for topping"));
        ingredients.addAll(ingredients18);
        List<Instruction> instructions18 = new ArrayList<>();
        instructions18.add(new Instruction("Spread the raspberry preserves in an even layer on the bottom of the crust."));
        instructions18.add(new Instruction("Beat together cream cheese, peanut butter and brown sugar until smooth."));
        instructions18.add(new Instruction("Gently fold in Cool Whip."));
        instructions18.add(new Instruction("Spread peanut butter mixture over raspberry layer."));
        instructions18.add(new Instruction("Cover loosely and refrigerate for 2 hours."));
        instructions18.add(new Instruction("Cut into slices and top with chopped peanuts and fresh raspberries before serving."));
        instructions.addAll(instructions18);
        recipes.add(new Recipe("0006ef8deb", "Peanut Butter & Jelly Pie", "http://www.kraftrecipes.com/recipes/peanut-butter-jelly-pie-173076.aspx", "train", ingredients18, instructions18));
        List<Pair> pairs18 = new ArrayList<>();
        pairs18.add(new Pair(" 03b8cd1303.jpg ", " https://assets.kraftfoods.com/recipe_images/173076_ABO_67001v0_WP.jpg"));
        pairs.addAll(pairs18);
        images.add(new Image("0006ef8deb", pairs18));

        this.ingredientRepository.saveAll(ingredients);
        this.instructionRepository.saveAll(instructions);
        this.pairRepository.saveAll(pairs);
        this.recipeRepository.saveAll(recipes);
        this.imageRepository.saveAll(images);
    }
}
