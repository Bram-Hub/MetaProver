package expression.metasentence;

import expression.sentence.Iff;
import expression.sentence.Sentence;
import logicalreasoner.truthassignment.TruthAssignment;
import metareasoner.metainference.MetaInference;
import metareasoner.proof.Proof;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * The IFF class represents the metalogical IFF statement
 */
public class IFF extends MetaSentence {
  public IFF(MetaSentence s1, MetaSentence s2, HashSet<TruthAssignmentVar> v) {
    super(new ArrayList<>(Arrays.asList(s1, s2)), "IFF", "IFF", v);
  }

  @Override
  public MetaSentence toplevelCopy(HashSet<TruthAssignmentVar> vars) {
    return this;
  }

  public MetaInference reason(Proof p, int inferenceNum) {
    if (args.get(0) instanceof MODELS && args.get(1) instanceof MODELS) {
      MODELS arg1 = (MODELS) args.get(0),
              arg2 = (MODELS) args.get(1);

      if (arg1.getTruthAssignmentVar() == arg2.getTruthAssignmentVar()) {
        Iff iff = (Iff) Sentence.makeSentence("iff", Arrays.asList(arg1.getSentence(), arg2.getSentence()));
        MODELS m = new MODELS(arg1.getTruthAssignmentVar(), iff, arg1.isModelled() == arg2.isModelled(), inferenceNum, true, true);
        ArrayList<MetaSentence> a = new ArrayList<>();
        a.add(m);

        return new MetaInference(this, a, inferenceNum, false, symbol);
      }
    }

    return null;
  }
}
