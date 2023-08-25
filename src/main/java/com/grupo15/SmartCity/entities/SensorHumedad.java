package com.grupo15.SmartCity.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "sensorhumedad")
@Getter @Setter @NoArgsConstructor
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class SensorHumedad extends Dispositivo {
	
}
