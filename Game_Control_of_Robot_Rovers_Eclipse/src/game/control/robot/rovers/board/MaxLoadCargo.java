package game.control.robot.rovers.board;

import java.util.List;
import java.util.stream.Collectors;
import java.io.Serializable;
import java.util.ArrayList;

public class MaxLoadCargo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Battery> batteriesInCargo = new ArrayList<>();
	private int rocks;
	private int maxLoad;

	public MaxLoadCargo(int maxLoad) {
		super();
		this.maxLoad = maxLoad;
	}

	public int load() {
		int batteryWeight = this.batteriesInCargo.stream().collect(Collectors.summingInt(b -> b.getWeight()));
		return batteryWeight + this.rocks;
	}

	public boolean addBattery(Battery battery) {
		if (this.load() + battery.getWeight() < this.maxLoad) {
			this.batteriesInCargo.add(battery);
			return true;
		} else {
			return false;
		}
	}

	public int addRock(int rocks) {
		if (this.load() + rocks < this.maxLoad) {
			this.rocks += rocks;
			return rocks;
		} else {
			Integer l = this.load();
			this.rocks += this.maxLoad - this.load();
			return this.maxLoad - l;
		}
	}

	public List<Battery> getBatteriesInCargo() {
		return batteriesInCargo;
	}

	public int getRocks() {
		return rocks;
	}

	public void releaseCargo() {
		this.batteriesInCargo = new ArrayList<>();
		this.rocks = 0;
	}

}
