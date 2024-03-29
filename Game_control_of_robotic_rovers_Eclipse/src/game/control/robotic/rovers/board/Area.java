package game.control.robotic.rovers.board;

import java.util.List;
import java.util.stream.Collectors;
import java.io.Serializable;
import java.util.ArrayList;

public class Area implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Robot> robots;
	private List<Battery> batteries;
	private List<Blizzard> blizzards;
	private List<ChargingStation> chargingStations;

	private int rocks = 0;
	private boolean hasChasm;

	private MotherShip motherShip;

	{
		this.robots = new ArrayList<>();
		this.batteries = new ArrayList<>();
		this.blizzards = new ArrayList<>();
		this.chargingStations = new ArrayList<>();
	}

	public Area() {
		super();
	}

	public Area(int rocks, boolean hasChasm) {
		super();
		this.rocks = rocks;
		this.hasChasm = hasChasm;
	}

	public List<Robot> getRobots() {
		return robots;
	}

	public List<Battery> getBatteries() {
		return batteries;
	}

	public List<Blizzard> getBlizzards() {
		return blizzards;
	}

	public List<ChargingStation> getChargingStations() {
		return chargingStations;
	}

	public int getRocks() {
		return rocks;
	}

	public boolean hasChasm() {
		return hasChasm;
	}

	public void setChasm(boolean chasm) {
		this.hasChasm = chasm;
	}

	public MotherShip getMotherShip() {
		return this.motherShip;
	}

	public void setMotherShip(MotherShip motherShip) {
		this.motherShip = motherShip;
	}

	public void addBattery(Battery battery) {
		this.batteries.add(battery);
	}

	public void addBatteries(List<Battery> batteries) {
		this.batteries.addAll(batteries);
	}

	public void addBatteriesAndRocks(List<Battery> batteries, Integer rocks) {
		this.addBatteries(batteries);
		this.addRocks(rocks);
	}

	public void addRocks(int rocks) {
		this.rocks += rocks;
	}

	public int mineRocks(int rocks) {
		if (rocks <= this.rocks) {
			this.rocks -= rocks;
			return rocks;
		} else {
			Integer r = this.rocks;
			this.rocks = 0;
			return r;
		}
	}

	public int getBlizzardVolume() {
		return this.getBlizzards().stream().collect(Collectors.summingInt(b -> b.getVolume()));
	}

}
