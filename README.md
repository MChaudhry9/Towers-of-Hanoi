# Towers of Hanoi Project-Backend

## This repository contains the backend logic for the Towers of Hanoi puzzle. It includes the core algorithm, game logic for user interactions, input validation, methods to display the state of the towers, and a winner banner when the winning condition is satisfied.

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Requirements](#requirements)
- [Setup](#setup)
- [How To Play](#how-to-play)
- [Gameplay](#gameplay)

## Introduction

The Towers of Hanoi is a classic puzzle game in computer science and mathematics where the objective is to move a stack of disks from the first tower to the last tower, following specific rules. This repository provides the core backend implementation of the puzzle.

## Features

- Core algorithm to solve the Towers of Hanoi puzzle.
- Input validation to ensure valid moves.
- Dynamic display of the current state of the towers.
- Congratulatory message upon successful completion of the puzzle.

## Requirements

- Java Development Kit (JDK) 8 or higher.
- A terminal or command prompt to run the application.
- EclipseIDE (recommended)

## Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/towers-of-hanoi-backend.git
   cd towers-of-hanoi-backend
2. **Compile the code**
   ``` bash
   javac -d bin src/test1/Start_test.java
3. **Run the application**
   ```bash
   java -cp bin test1.Start_test
4. Play in the console of EclipseIDE or other environments

## How To Play 
1. Start the game:
Run the application as described in the setup section.

2. Enter the number of disks:
When prompted, enter the number of disks you want to use in the puzzle.

3. Make your moves:
Follow the prompts to move disks from one tower to another. Enter the tower numbers as instructed (e.g., 1 3 to move a disk from tower 1 to tower 3).

4. Solve the puzzle:
Continue making moves until all disks are successfully moved to the target tower.

## Gameplay
The Towers of Hanoi puzzle consists of three towers and a number of disks of different sizes. The initial state has all disks stacked on the first tower in decreasing size from bottom to top. The goal is to move all the disks to the third tower, following these rules:

1. Only one disk can be moved at a time.
2. A disk can only be placed on top of a larger disk or on an empty tower.
3. The objective is to move all disks from the start tower to the end tower using the fewest moves possible.
