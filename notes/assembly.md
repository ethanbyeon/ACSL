Accumulator (ACC): where the result of each operation is stored

LABEL OPCODE LOC
LOAD: Contents of LOC placed in ACC (*LOC remains unchanged)
STORE: Contents of ACC are placed in LOC
LOC: Reference to a label or immediate data

Operations:
ADD, SUB, MULT, & DIV

Branches
BG: If ACC > 0
BE: If ACC = 0
BL: If ACC < 0
BU: Branch to the instruction labeled with LOC

READ: Read a signed integer into LOC
PRINT: Print contents of LOC
DC: Stores a specified contstant defined by the LABEL field
END: Program terminates
