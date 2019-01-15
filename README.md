# SemanticProver
## Authors
2017:
Kevin O'Neill
Mitchell Mellone

## About
SemanticProver is an implementation on a truth-functional metatheory of logic which manipulates explicitly stored truth assignments in order to solve both propositional and metalogical problems. SemanticProver.jar is our latest release which contains a GUI to display truth assignment trees for any given proof.

Here's the gist of how to do a proof:
 

1.) Launch the .jar by double-clicking on it.
 

2.) Choose the type of proof you want in the File menu (propositional/predicate, FOL, meta-logic).
 

2a.) For propositional/predicate and FOL proofs, you can choose between the automated prover and the proof assistant, which allows you to manually expand the truth tree.
 

3a.) Enter sort declarations. I use a sorted logic, so this part is unfortunately necessary. There are built-in Object and Boolean sorts for constants and T/F, but other sorts can be added using the declaration (declare-sort <sort-name> <super-sort>).
 

3b.) Enter predicate/function/constant declarations. Just like you can define sort hierarchies, you can define how they're used. To define functions use the declaration (<output-type> <function-name> ...<argument-types>...). Predicates are functions that return booleans, so they simply sub in Boolean as the output-type. So a proposition P is declared as (Boolean P), where a binary predicate LeftOf is declared as (Boolean LeftOf Object Object). Finally constants are just null-ary functions, so they can be defined using the declaration (<type> <constant-name>), as in (Man socrates).
 

4.) Now that all of the declarations are in, you can enter in all of the premises on the upper-right text box. The operators all are spelled out as words. The notable parts are that I use "implies" for the material conditional, "forAll" for the universal quantifier, and "exists" for the existential quantifier. Also for the quantifiers, the quantified variable can either be un-sorted, like in the expression (forAll x (P x)), or sorted, like in the expression (forAll (Man x) (Mortal x)).
 

5.) Enter the goal of the proof in the lower-right text box. The syntax for this is exactly the same as for the premises.
 

6.) View/expand the proof. If the automatic mode was set, the proof should already be complete. You can drag boxes around and scroll if you need to see better. If the proof assistant mode was selected than you have to apply rules to statements by double-clicking on them. The statements are all numbered and have justifications so you can track where things came from. The bottom panel will also display all of the inferences (decompositions, branches, and instantiations) that have been made. Additionally the right-most column either has a check if the statement was decomposed, an "x" if it needs to be decomposed, or if the statement is a universal quantifier it has a list of all of the constants it was instantiated over. Finally, the bottom row will have an "o" if the branch is open or an "x" if it is closed.
 

And you're done! If you get to the point where the proof is complete a window will pop up and tell you if the argument was valid or invalid.
 

In the file menu there's an option for loading proofs from a text file- this helps if you don't want to have to type out the proof every time. I've included two sample files for you to show how they're structured, and to see a clear example of how the syntax looks.
 

I wanted to get some functionality for saving proofs (or perhaps even auto-grading proofs) but also never got around to that part. I wish there were better documentation for the program, but as you know that's real work. Perhaps if you've got a student who can program well looking for a final project, you can point them my direction. Let me know if you have questions, or if you want me to talk about the meta-logic part of the prover.

Questions?
Contact Kevin O'Neill at oneilk4@rpi.edu
