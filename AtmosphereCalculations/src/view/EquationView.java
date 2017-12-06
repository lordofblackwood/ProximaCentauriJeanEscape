package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class EquationView extends JFrame {
  JPanel buttonPanel;
  JButton apply;
  JTextArea temperature;
  JTextArea atmosphere;
  JTextField distanceFromProximaCentauri;
  JTextField massOfParticle;
  JTextArea tempName;
  JTextArea atmoName;
  JTextArea distanceName;
  JTextArea massName;

  public EquationView() {
    super();
    this.setTitle("Proxima Centauri B");
    this.setSize(1300, 90);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setLayout(new BorderLayout());
    this.setPreferredSize(new Dimension(1300, 90));

    buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout());
    this.add(buttonPanel, BorderLayout.CENTER);

    apply = new JButton("apply");
    temperature = new JTextArea();
    atmosphere = new JTextArea();
    distanceFromProximaCentauri = new JTextField();
    massOfParticle = new JTextField();
    tempName = new JTextArea();
    atmoName = new JTextArea();
    distanceName = new JTextArea();
    massName = new JTextArea();

    temperature.setColumns(10);
    temperature.setRows(1);
    atmosphere.setColumns(10);
    atmosphere.setRows(1);
    distanceFromProximaCentauri.setColumns(10);
    massOfParticle.setColumns(10);

    tempName.setText("Temperature in Kelvin");
    atmoName.setText("Percent of Earth's Atmosphere Lost per Giga");
    distanceName.setText("Distance from Proxima Centauri in AU");
    massName.setText("The molar mass");

    temperature.setEditable(false);
    atmosphere.setEditable(false);
    tempName.setEditable(false);
    atmoName.setEditable(false);
    distanceName.setEditable(false);
    massName.setEditable(false);

    buttonPanel.add(distanceFromProximaCentauri);
    buttonPanel.add(distanceName);
    buttonPanel.add(massOfParticle);
    buttonPanel.add(massName);
    buttonPanel.add(temperature);
    buttonPanel.add(tempName);
    buttonPanel.add(atmosphere);
    buttonPanel.add(atmoName);
    buttonPanel.add(apply);

  }

  public void makeVisible() {
    this.setVisible(true);
  }

  public void refresh() {
    this.repaint();
  }

  public void setListener(ActionListener listener) {
    this.apply.addActionListener(listener);
  }

  public String getDistance() {
    return distanceFromProximaCentauri.getText();
  }

  public String getMass() {
    return massOfParticle.getText();
  }

  public void setAtmosphere(String atmosophere) {
    this.atmosphere.setText(atmosophere);
  }

  public void setTemperature (String temperature) {
    this.temperature.setText(temperature);
  }
}
