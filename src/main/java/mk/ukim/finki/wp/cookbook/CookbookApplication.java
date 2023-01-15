package mk.ukim.finki.wp.cookbook;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import mk.ukim.finki.wp.cookbook.service.RecipeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ServletComponentScan
public class CookbookApplication {

    public static void main(MysqlxDatatypes.Scalar.String[] args) {
        SpringApplication.run(CookbookApplication.class, String.valueOf(args));
    }

    @Bean
    CommandLineRunner runner(RecipeService recipeService) {
            return args -> {
                // read JSON and load json
//                ObjectMapper mapper = new ObjectMapper();
//                TypeReference<List<Recipe>> typeReference = new TypeReference<List<Recipe>>(){};
//                InputStream inputStream = TypeReference.class.getResourceAsStream("/json/main.json");
//                try {
//                    List<Recipe> recipes = mapper.readValue(inputStream,typeReference);
//                    recipeService.save(recipes);
//                    System.out.println("Recipes Saved!");
//                } catch (IOException e){
//                    System.out.println("Unable to save recipes: " + e.getMessage());
//                }
            };
    }


}
