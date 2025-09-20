# Forward Difference Method with GUI (Java Swing)

This project is a **Java Swing application** that implements the **Forward Difference Method** for numerical differentiation.  
It provides a graphical interface for input and displays the calculation results in a formatted table with error analysis.

## Features
- GUI-based input for:
  - Bottom Limit (**a**)
  - Upper Limit (**b**)
  - Step Value (**h**)
- Displays results in a text area with table formatting:
  - `x`
  - `f(x)`
  - Approximate derivative `f'(x)`
  - Exact derivative `f'(x)`
  - Error
- Calculates and shows the **average error** in a message dialog.
- Clean and responsive interface using Java Swing.

## Function Used
The program currently uses:

\[
f(x) = x^2
\]

with exact derivative:

\[
f'(x) = 2x
\]

*(You can modify the function `f(x)` and `fEksak(x)` in the source code as needed.)*

## How to Run
1. Clone this repository:
   ```bash
   git clone https://github.com/username/repo-name.git
