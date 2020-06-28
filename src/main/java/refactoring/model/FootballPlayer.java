package refactoring.model;

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

  public double getPasserRating() {
    return passerRating;
  }

  public void setPasserRating(double passerRating) {
    this.passerRating = passerRating;
  }

  public int getRushingYards() {
    return rushingYards;
  }

  public void setRushingYards(int rushingYards) {
    this.rushingYards = rushingYards;
  }

  public int getReceivingYards() {
    return receivingYards;
  }

  public void setReceivingYards(int receivingYards) {
    this.receivingYards = receivingYards;
  }

  public int getTotalTackles() {
    return totalTackles;
  }

  public void setTotalTackles(int totalTackles) {
    this.totalTackles = totalTackles;
  }

  public int getInterceptions() {
    return interceptions;
  }

  public void setInterceptions(int interceptions) {
    this.interceptions = interceptions;
  }

  public int getFieldGoals() {
    return fieldGoals;
  }

  public void setFieldGoals(int fieldGoals) {
    this.fieldGoals = fieldGoals;
  }

  public int getAvgPunt() {
    return avgPunt;
  }

  public void setAvgPunt(int avgPunt) {
    this.avgPunt = avgPunt;
  }

  public int getAvgKickoffReturn() {
    return avgKickoffReturn;
  }

  public void setAvgKickoffReturn(int avgKickoffReturn) {
    this.avgKickoffReturn = avgKickoffReturn;
  }

  public int getAvgPuntReturn() {
    return avgPuntReturn;
  }

  public void setAvgPuntReturn(int avgPuntReturn) {
    this.avgPuntReturn = avgPuntReturn;
  }
}
