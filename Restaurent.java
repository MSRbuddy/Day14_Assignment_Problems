import java.util.*;

class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "Name: " + name + ", Price: " + price;
    }
}

class Restaurant {
    private String name;
    private Map<String, MenuItem> menuItems;

    public String getName() {
        return name;
    }
    public Restaurant(String name) {
        this.name = name;
        this.menuItems = new HashMap<>();
    }

    public void addMenuItem(MenuItem menuItem) {
        menuItems.put(menuItem.getName(), menuItem);
        System.out.println("Menu item added successfully.");
    }

    public void removeMenuItem(String itemName) {
        if (menuItems.containsKey(itemName)) {
            menuItems.remove(itemName);
            System.out.println("Menu item removed successfully.");
        } else {
            System.out.println("Menu item not found.");
        }
    }

    public void displayMenuItems() {
        if (menuItems.isEmpty()) {
            System.out.println("No menu items found in the restaurant.");
        } else {
            System.out.println("All menu items in the restaurant:");
            for (MenuItem menuItem : menuItems.values()) {
                System.out.println(menuItem);
            }
        }
    }

    public MenuItem searchMenuItem(String itemName) {
        if (menuItems.containsKey(itemName)) {
            return menuItems.get(itemName);
        } else {
            return null;
        }
    }
}

class RestaurantMenuManagement {
    private Map<String, Restaurant> restaurants;

    public RestaurantMenuManagement() {
        restaurants = new HashMap<>();
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.put(restaurant.getName(), restaurant);
        System.out.println("Restaurant added successfully.");
    }

    public void addMenuItemToRestaurant(Restaurant restaurant, MenuItem menuItem) {
        if (restaurants.containsKey(restaurant.getName())) {
            restaurant.addMenuItem(menuItem);
        } else {
            System.out.println("Restaurant not found.");
        }
    }

    public void removeMenuItemFromRestaurant(Restaurant restaurant, String itemName) {
        if (restaurants.containsKey(restaurant.getName())) {
            restaurant.removeMenuItem(itemName);
        } else {
            System.out.println("Restaurant not found.");
        }
    }

    public void displayMenuItemsInRestaurant(Restaurant restaurant) {
        if (restaurants.containsKey(restaurant.getName())) {
            restaurant.displayMenuItems();
        } else {
            System.out.println("Restaurant not found.");
        }
    }

    public MenuItem searchMenuItemInRestaurant(Restaurant restaurant, String itemName) {
        if (restaurants.containsKey(restaurant.getName())) {
            return restaurant.searchMenuItem(itemName);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RestaurantMenuManagement restaurantMenuManagement = new RestaurantMenuManagement();

        while (true) {
            System.out.println("\n---- Restaurant Menu Management System Menu ----");
            System.out.println("1. Add Restaurant");
            System.out.println("2. Add Menu Item to Restaurant");
            System.out.println("3. Remove Menu Item from Restaurant");
            System.out.println("4. Display Menu Items in Restaurant");
            System.out.println("5. Search Menu Item in Restaurant");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter restaurant name: ");
                    String restaurantName = scanner.nextLine();

                    Restaurant newRestaurant = new Restaurant(restaurantName);
                    restaurantMenuManagement.addRestaurant(newRestaurant);
                    break;

                case 2:
                    System.out.print("Enter restaurant name: ");
                    String addMenuItemRestaurantName = scanner.nextLine();
                    System.out.print("Enter menu item name: ");
                    String menuItemName = scanner.nextLine();
                    System.out.print("Enter menu item price: ");
                    double menuItemPrice = scanner.nextDouble();
                    scanner.nextLine(); // Consume the newline character

                    MenuItem newMenuItem = new MenuItem(menuItemName, menuItemPrice);
                    Restaurant addMenuItemRestaurant = getRestaurantByName(restaurantMenuManagement, addMenuItemRestaurantName);
                    if (addMenuItemRestaurant != null) {
                        restaurantMenuManagement.addMenuItemToRestaurant(addMenuItemRestaurant, newMenuItem);
                    } else {
                        System.out.println("Restaurant not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter restaurant name: ");
                    String removeMenuItemRestaurantName = scanner.nextLine();
                    System.out.print("Enter menu item name to remove: ");
                    String removeMenuItemName = scanner.nextLine();

                    Restaurant removeMenuItemRestaurant = getRestaurantByName(restaurantMenuManagement, removeMenuItemRestaurantName);
                    if (removeMenuItemRestaurant != null) {
                        restaurantMenuManagement.removeMenuItemFromRestaurant(removeMenuItemRestaurant, removeMenuItemName);
                    } else {
                        System.out.println("Restaurant not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter restaurant name: ");
                    String displayMenuItemsRestaurantName = scanner.nextLine();

                    Restaurant displayMenuItemsRestaurant = getRestaurantByName(restaurantMenuManagement, displayMenuItemsRestaurantName);
                    if (displayMenuItemsRestaurant != null) {
                        restaurantMenuManagement.displayMenuItemsInRestaurant(displayMenuItemsRestaurant);
                    } else {
                        System.out.println("Restaurant not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter restaurant name: ");
                    String searchMenuItemRestaurantName = scanner.nextLine();
                    System.out.print("Enter menu item name to search: ");
                    String searchMenuItemName = scanner.nextLine();

                    Restaurant searchMenuItemRestaurant = getRestaurantByName(restaurantMenuManagement, searchMenuItemRestaurantName);
                    if (searchMenuItemRestaurant != null) {
                        MenuItem searchedMenuItem = restaurantMenuManagement.searchMenuItemInRestaurant(searchMenuItemRestaurant, searchMenuItemName);
                        if (searchedMenuItem != null) {
                            System.out.println("Menu item found: " + searchedMenuItem);
                        } else {
                            System.out.println("Menu item not found.");
                        }
                    } else {
                        System.out.println("Restaurant not found.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static Restaurant getRestaurantByName(RestaurantMenuManagement restaurantMenuManagement, String restaurantName) {
        for (Restaurant restaurant : restaurantMenuManagement.restaurants.values()) {
            if (restaurant.getName().equalsIgnoreCase(restaurantName)) {
                return restaurant;
            }
        }
        return null;
    }
}
