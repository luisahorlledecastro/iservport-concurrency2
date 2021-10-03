# Concurrency Game

## Setup
  - Each Player is assigned a team, either RED or BLACK
  - They each have an empty hand
  - On the table there are 16 cards. These are the Aces (A), Jacks (J), Queens (Q) and Kings (K) of each suit in both colours
  - The heap contains the remaining cards

## Start
- A random player is selected to start by taking a card from the table. If the card's colour...
  - matches that of the player's team they must add it to their hand. A card from the heap is added to the table in its place
  - does not match that of the player's team they must return it to the table

## End of the game
- The game ends when one of the players is able to hold in their hand a sequence A, J, Q, K of cards of the same suit.