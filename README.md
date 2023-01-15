# COOKBOOK-Project
The general theme for this project is Recipes. The front page of this web application shows a title with a quote, and below it is a Carousel, implemented using Slider by "react-slick". All the images used in the recipes go to this Carousel. The menu shows several sections on which we can go to the appropriate page by clicking and a Search section for searching for recipes. Clicking on Categories displays a Dropdown with options for All Recipes, Salty, Sweet, Fit. Clicking on one of the offered recipes displays, where each recipe is represented by a card using Bootstrap. A recipe is characterized by a title, image, Save and Learn More buttons. By clicking the Learn More button, we are directed to a new page where a detailed description of the recipe, with its ingredients and instructions, is displayed. By clicking on the Save button on the card, we have the opportunity to save the recipe. Bootstrap pagination is used for the recipes. By clicking on My Recipes from the menu, we are directed to a page where the Add Recipe button appears. Saving a recipe creates a list of Saved Recipes. By clicking on Add Recipe, we go to the page where we fill in the information needed to create a new recipe and add it to the My Recipes list, which is located under the saved recipes section. Be careful, when adding a recipe, the title, at least one ingredient and at least one instruction must be added. By clicking on Find Restaurants, we are directed to a page where a map implemented using GoogleMap from "react-google-maps" appears. The map is centered on our faculty and all the restaurants in the area are marked on this map. By clicking on one of the markers, details about the recommended restaurant are given, including its name, picture and address. In the left part there is a list of all restaurants as well as the possibility to search by name. By clicking on a field from the list, the restaurant and its details are displayed on the map. The last part of the menu is for searching recipes, in the field you write an ingredient, for example banana, and after clicking on the Search button, all the recipes that contain banana are listed.

## GETTING STARTED GUIDE:
The whole project with backend and frontend is located in the same folder. The project opens in IntelliJ. First, the backend is started with Run, and then in Terminal we set the frontend path, first write npm install and then npm start.
