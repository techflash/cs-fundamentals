package refactoring.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class FootballPlayer {

  private double passerRating;
  private int rushingYards;
  private int receivingYards;
  private int totalTackles;
  private int interceptions;
  private int fieldGoals;
  private int avgPunt;
  private int avgKickoffReturn;
  private int avgPuntReturn;

  // Constructors cant have same no of arguments having same type hence following two method
  // solve that particular problem
  public static FootballPlayer createRushingPlayer(int rushingYards) {
    return new FootballPlayer().setRushingYards(rushingYards);
  }

  public static FootballPlayer createReceivingPlayer(int receivingYards) {
    return new FootballPlayer().setReceivingYards(receivingYards);
  }

}
