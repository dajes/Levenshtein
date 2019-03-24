# Levenshtein

Project about finding Levenshtein distance using algorithm of O(n^2) complexity using matrix with starting word represented as column and goal string is the row. Each movement vertically means deleting the symbol of the row from the original string, horizontally means adding a symbol of the column and diagonally means replacing the symbol of the row with the symbol of the column.
Iteretively for each cell algorithm is deciding which option is the best (takes a minimum cost for performing) and adding that to the cells current cost. As a result we get a matrix where bottom left corner is the answer how many moves in the best case we must take to change the first string to the second one using basic operations: replacing, removing and inserting.
