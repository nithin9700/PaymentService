# Magical Arena

Welcome to the **Magical Arena**, where players engage in thrilling battles using their health, strength, and attack attributes. In this arena, players fight to defeat their opponents by reducing their health to zero.

## Game Rules

| Rule                  | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
|-----------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Player Attributes** | Every player in the arena is defined by the following attributes:<br> - **Health**: Represents the player's life points. The player dies if their health reaches zero.<br> - **Strength**: Determines the player's defensive capabilities.<br> - **Attack**: Represents the player's offensive power.                                                                                                                                                                                          |
| **Combat Mechanics**  | - Players take turns attacking each other.<br> - The attacking player rolls the attacking dice, and the defending player rolls the defending dice.<br> - The attacker's attack value, multiplied by the outcome of the attacking dice roll, determines the damage inflicted.<br> - The defender's strength value, multiplied by the outcome of the defending dice roll, determines the damage defended.<br> - The defender's health is reduced by the excess damage inflicted by the attacker. |
| **Turn Order**        | - The player with lower health attacks first at the start of a match.                                                                                                                                                                                                                                                                                                                                                                                                                          |

## Example Gameplay

Let's illustrate the gameplay with an example:

- **Player A**:
    - Health: 50
    - Strength: 5
    - Attack: 10

- **Player B**:
    - Health: 100
    - Strength: 10
    - Attack: 5

1. **Player A attacks**:
    - Rolls die: 5
    - Attack damage: 5 * 10 = 50
    - Player B defends:
        - Rolls die: 2
    - Defending strength: 10 * 2 = 20
    - Player B's health reduced by 30 to 70.

2. **Player B attacks**:
    - Rolls die: 4
    - Attack damage: 4 * 5 = 20
    - Player A defends:
        - Rolls die: 3
    - Defending strength: 5 * 3 = 15
    - Player A's health reduced by 5 to 45.

3. The game continues until one player's health reaches zero, ending the match.

## Implementation

The game's implementation includes the following components:
- **Player Class**: Defines the attributes and behavior of a player.
- **Arena Class**: Manages the gameplay and conducts matches between players.
- **GameService Class**: Handles the combat mechanics and turn order.

## Running the Game

To play the game:
1. Compile the source files.
2. Run the `Game` class or invoke the necessary methods to start a match in the Magical Arena.

Enjoy the thrilling battles in the Magical Arena and emerge victorious!
