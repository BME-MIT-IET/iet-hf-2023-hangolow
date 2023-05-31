# Test cases

Manual test testcases for the Use-Cases that were previously outlined in the specification.

1. Map
   - There is graphical interface that the user can interact with.
   - The actions that can be taken by the player are present in this interface.
   - Every feature of the GUI should be obvious. 
   - The UI is responsive.
   - It should be clear, which player's turn it is and the current field they stand on.

2. Move
   - The possible fields to move to and the resulting action of such moves should be obvious for the user.
   - The field where the player ends up after a move should be obvious and well indicated.
   - Depending on the agents applied to the player, certain move "rules" should apply (e.g.: Player infected with bear virus).

3. Do field operation
   - Every different type of field should have a distinct "field operation", such as learn, acquire equipment etc.
      + Test every such feature.
   - The program should make sure that the player can only execute these actions if certain requirements are met.
   - Field types and their corresponding special actions:
      + Laboratory - Learn a new genetic code
      + Warehouse - Contains resources, like Amino Acid and Nucleotide, that can be collected
      + Shelter - Contains lootable equipment, that gives perks to the player
      + Field - no special action
   - Equipment can be dropped on any field type, including basic fields as well.

4. Use Agent
   - Every character should be able to craft agents and inject them on other virologists or themselves.
   - Agents can only be crafted after learning their genetic code from a laboratory.
   - Crafting agents cost resources.
   - If the player does not have enough, crafting should not be allowed. There should be some kind of feedback about this.
   - The result of trying to inject an enemy player with an agent should be obvious.
   - The effects of (most of) the agents are temporary.
   - The agents and their effects:
     + Block: Removes the effects of all other agents.
     + Bear: Makes the player move unexpectedly. When moving to other fields, the players on the given field are also infected. Cannot be removed. Players with the bear virus are only vulnerable to the Axe equipment.
     + Chorea: It forces the player to take up to three random moves, depleting their action count.
     + Forget: Makes the player forget all learned genetic codes.
     + Stun: Makes the player unable to perform all actions for a certain number of turns.
  
5. Steal
	- Players can steal equipment or resources (Amino Acid, Nucleotide) from enemy players.
	- Only when the enemy player is stunned and are on the same field.
	- And there is empty space in their inventory

6. Round:
	- The players have a certain amount of actions that they can take in a given turn.
	- Executing an action results in the player losing an action.
	- Players can choose to give up their remaining turns