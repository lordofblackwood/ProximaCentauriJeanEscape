package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import model.EquationModel;
import view.EquationView;

public class EquationController implements ActionListener {
  EquationModel model;
  EquationView view;

  public EquationController(EquationModel model, EquationView view) {
    this.model = model;
    this.view = view;
  }

  public void StartView() {
    this.view.makeVisible();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    try {
      double distance = Double.parseDouble(view.getDistance());
      model.setDistance(distance);
    } catch (Exception ex) {
      throw ex;
    }
    try {
      double mass = Double.parseDouble(view.getMass());
      model.setMass(mass);
    } catch (Exception ex) {
      throw ex;
    }
    view.setTemperature(Double.toString(model.getTemp()));
    view.setAtmosphere(Double.toString(model.getPercentOfEarthAtmo()));
    view.refresh();
  }
}
