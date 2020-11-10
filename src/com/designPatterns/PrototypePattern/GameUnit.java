package com.designPatterns.PrototypePattern;

import javafx.geometry.Point3D;

/**
 * This class represents an abstract prototype & defines the clone method. Cloneable is referred to as a 'marker' class, that
 * is it does not define any methods at all
 */
public abstract class GameUnit implements Cloneable {

	// no setters for position, so position is immutable; hence, clone() implements shallow copying referencing current composite objects
	private Point3D position;

	// instantiate GameUnit at the origin (set specific coords with other constructor below)
	public GameUnit() {
		position = Point3D.ZERO;
	}
	

	// this is overridden in subclasses and can throw CloneNotSupportedException if cloning not supported (see General subclass)
	@Override
	public GameUnit clone() throws CloneNotSupportedException {
		GameUnit unit = (GameUnit)super.clone();		// shallow copy
		unit.initialize();
		return unit;
	}

	protected void initialize() {
		this.position = Point3D.ZERO;
		reset();
	}

	// can be used to reset the state of a object (for example); this allows clones to adopt the same initial properties
	// and distinguish them from current objects of the same type
	protected abstract void reset();

	// instantiate GameUnit at a specific set of coords
	public GameUnit(float x, float y, float z) {
		position = new Point3D(x, y, z);
	}

	public void move(Point3D direction, float distance) {
		Point3D finalMove = direction.normalize();
		finalMove = finalMove.multiply(distance);
		position = position.add(finalMove);
	}
	
	public Point3D getPosition() {
		return position;
	}
}
