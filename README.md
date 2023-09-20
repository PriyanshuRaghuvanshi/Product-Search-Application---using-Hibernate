# Product-Search-Application---using-Hibernate for Database Integration 

This is a Java project that searches for T-shirts in CSV files containing product data for different brands (Nike, Puma, Adidas) and saves the data to a MySQL database. Users can specify their preferences such as color, size, gender, and output sorting preference to find matching T-shirts.

## Features

- Accepts the following input parameters:
  - Color
  - Size
  - Gender (M=Male, F=Female)
  - Output Preference (Price, Rating, or both)
- Searches for T-shirts in CSV files for Nike, Puma, and Adidas.
- Allows adding more CSV files for additional brands.
- Uses OpenCSV for reading and parsing CSV files.
- Integrates Hibernate to save data to a MySQL database.
- Dynamically loads new CSV files at a configurable location.
- User-friendly error message if no suitable T-shirt is found.
- Implemented as a Maven project.
- Utilizes Java 8 features wherever possible.

## Usage

To run the program, follow these steps:

1. Clone the repository or download the source code.

2. Set up your MySQL database and configure Hibernate properties in the `hibernate.cfg.xml` file.

3. Navigate to the project directory.

4. Build the project using Maven:

   ```shell
   mvn clean install
   ```

5. Run the program with the following command, providing the input parameters:

   ```shell
   java -jar target/tshirt-product-search.jar <Color> <Size> <Gender> <OutputPreference>
   ```

   Replace `<Color>`, `<Size>`, `<Gender>`, and `<OutputPreference>` with your desired values.

## Database Integration

The program uses Hibernate to save T-shirt data to a MySQL database. You can configure the database connection and other Hibernate properties in the `hibernate.cfg.xml` file.

## Example

Here's an example of how to search for T-shirts and save the data to the database:

```shell
java -jar target/tshirt-product-search.jar Blue L M Price
```

Output:
```
Matching T-Shirts:
1. Brand: Nike, Model: Nike T-Shirt 1, Color: Blue, Size: L, Price: $20, Rating: 4.5
2. Brand: Adidas, Model: Adidas T-Shirt 2, Color: Blue, Size: L, Price: $22, Rating: 4.0
3. Brand: Puma, Model: Puma T-Shirt 3, Color: Blue, Size: L, Price: $18, Rating: 4.2

Data saved to the database.
```

## Adding More CSV Files

You can add more CSV files for additional brands by placing them in the configurable location. The program will automatically load new CSV files at runtime.

## Building the JAR File

An Ant script is provided to build a JAR file for the program. Run the following command to build the JAR file:

```shell
ant build-jar
```

The JAR file will be created in the `target` directory.
