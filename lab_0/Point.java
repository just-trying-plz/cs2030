public class Point {
  private final double x, y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return this.x;
  }

  public double getY() {
    return this.y;
  }

  public double distance(Point q) {
    double dx = this.x - q.x;
    double dy = this.y - q.y;
	  return Math.sqrt(dx * dx + dy* dy);
	}

  public Point midPoint(Point p) {
    double midPointX = (this.x + p.x) / 2;
    double midPointY = (this.y + p.y) / 2;
    return new Point(midPointX, midPointY);
  }

  public double angleTo(Point p) {
    // Points are the same
    if (this.equals(p)) {
      return 0;
    }

    double xDist = p.x - this.x;
    double yDist = p.y - this.y;

    if (xDist == 0) {
      // Point is directly above
      if (p.y > this.y) {
        return Math.PI / 2;
      // Point is directly below
      } else {
        return - Math.PI / 2;
      }
    } else if (yDist == 0) {
      // Point is on the right
      if (p.x > this.x) {
        return 0;
      // Point is on the left
      } else {
        return Math.PI; 
      }
    }

    double refAngle =  Math.atan(xDist/yDist);

    // Q1
    if (p.x >= this.x && p.y >= this.y) {
      return refAngle;
    // Q2
    } else if (p.x < this.x && p.y >= this.y) {
      return Math.PI + refAngle;
    // Q3
    } else if (p.x < this.x && p.y < this.y) {
      return refAngle - Math.PI;
    // Q4
    } else {
      return refAngle;
    }
  }

  public Point moveTo(double angle, double distance) {
    if (distance == 0) {
      return this;
    }
    
    return new Point(this.x + distance * Math.cos(angle), this.y + distance * Math.sin(angle));
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    } else if (obj instanceof Point) {
      Point p = (Point) obj;
      return Math.abs(this.x - p.x) < 1E-15 && Math.abs(this.x - p.x) < 1E-15;
    } else {
      return false;
    }
  }

  @Override
  public String toString() {
    return "point (" + String.format("%.3f", this.x) + ", " + String.format("%.3f", this.y) + ")";
  }
}