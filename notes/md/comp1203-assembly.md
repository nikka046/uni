---
title:  'COMP1203 - ARM & Assembly'
author: Dominik Tarnowski (tdom.dev)
date: 19/11/19
---

# ARM Assembler

## Arm Instruction Set
 * Full instruction set: 32-bit
 * "Thumb" instruction set: 16-bit
 * Optimised for higher code density from C code
   * $\approx\ 65$% of full instruction set

### ARM Registers
 * 16x32-bit registers, **R0** to **R15**
 * 3 special ones
   * **R15** - Program Counter (PC)
   * **R14** - Link Register (LR)
   * **R13** - Stack Pointer (SP)

 * **CPSR** - Current Program Status Register

### Instruction Set

| Instruction | Explaination |
| -- | -- |
| mov r2, r1 | r2 = r1 |
| add r3, r1, r2 | r3 = 31 + r2 | 
| B <label> | Branch to label |

TODO: rest of instructions mentioned in the presentation

### Status Registers

TODO



