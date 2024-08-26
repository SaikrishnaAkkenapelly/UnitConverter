# Unit Converter: A Jane Street Project

## Overview

The Unit Converter Program is designed to convert measurements between different units, provided the units are convertible based on predefined conversion facts. This program initializes with a set of conversion facts, enabling it to serve conversion requests immediately after startup.

## Features

- **Predefined Conversion Facts:** The program initializes with a set of conversion facts that allow conversions between various units of measurement.
- **Dynamic Conversion:** Supports conversion between any units as long as a conversion path exists.
- **Error Handling:** Gracefully handles cases where units are not convertible.

## Conversion Facts

The program is initialized with the following sample conversion facts:

- **Length Conversions:**
  - 1 meter = 3.28 feet
  - 1 foot = 12 inches
  - 1 inch = 2.54 centimeters

- **Time Conversions:**
  - 1 hour = 60 minutes
  - 1 minute = 60 seconds

These facts enable a wide range of conversions between units of length and time.

## How It Works

Upon initialization, the Unit Converter Program loads the predefined conversion facts. Once loaded, the program can:

1. **Find Conversion Paths:** Determine if a conversion is possible between two units by finding a path through the loaded conversion facts.
2. **Perform Conversions:** Compute the result of converting one unit to another using the appropriate conversion factors.
3. **Handle Non-convertible Units:** Provide informative responses when a conversion between the requested units is not possible.

## Sample Conversions

Here are some examples of conversions that the program can perform:

1. **Length Conversions:**
   - `2 meters -> ? centimeters`  
     **Result:** 200 centimeters
   - `2 meters -> ? inches`  
     **Result:** 78.72 inches
   - `13 inches -> ? meters`  
     **Result:** 0.330 meters

2. **Time Conversions:**
   - `1 hour -> ? seconds`  
     **Result:** 3600 seconds
   - `5 minutes -> ? seconds`  
     **Result:** 300 seconds

3. **Non-convertible Units:**
   - `1 inch -> ? seconds`  
     **Result:** Not convertible

## Conclusion

The Unit Converter Program is a versatile tool for converting between various units of measurement. By initializing with a comprehensive set of conversion facts, it ensures accurate and efficient conversions. This project is a demonstration of robust design and thoughtful implementation, capable of handling a wide range of conversion requests with ease.