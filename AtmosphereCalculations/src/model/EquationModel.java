package model;

public class EquationModel {
  double solar;
  double distance;
  double radiusOfPlanet;
  double sigma;
  double albedo;
  double escapeVelocity;
  double boltsmannConstant;
  double numberDensity;
  double massOfParticle;
  double fluxToAtmo;
  double earthAtmo;

  public EquationModel() {
    this.solar = 899.2;
    this.radiusOfPlanet = 0.05;
    this.albedo = 0.15;
    this.sigma = 5.67 * Math.pow(10, -8);
    this.escapeVelocity = 12025;
    this.boltsmannConstant = 1.38064852 * Math.pow(10,-23);
    this.fluxToAtmo = 5.1 * Math.pow(10, 14) * 3.154 * Math.pow(10, 7) * Math.pow(10, 12);
    this.numberDensity = 1;
    this.earthAtmo = 5.1 * Math.pow(10, 18);
  }

  public void setDistance(double distance) {
    this.distance = distance;
  }

  public void setMass(double mass) {
    this.massOfParticle = mass * 1.66 * Math.pow(10, -27);
  }

  private double solarConstant() {
    return (radiusOfPlanet * radiusOfPlanet * solar) / (distance * distance);
  }

  public double getTemp() {
    double value = solarConstant() * (1 - albedo) / (4 * sigma);
    return Math.pow(value , 0.25);
  }

  public double getAtmosphere() {
    double v0 = Math.sqrt((2 * boltsmannConstant * getTemp()) / massOfParticle);
    double term1 = (numberDensity * v0) / (2 * Math.PI);
    double term2 = (((escapeVelocity * escapeVelocity) / (v0 * v0)) + 1);
    double term3 = Math.exp(0 - ((escapeVelocity * escapeVelocity) / (v0 * v0)));
    System.out.println("Atmo: " + term1 * term2  * term3 * fluxToAtmo + "\tVo: " + v0);
    return term1 * term2  * term3 * fluxToAtmo;
  }

  public double getPercentOfEarthAtmo() {
    return 100 * (getAtmosphere() / this.earthAtmo);
  }
}
