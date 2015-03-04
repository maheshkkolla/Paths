public class Path {
	City from;
	City to;
	Path (City from, City to) {
		this.from = from;
		this.to = to;
	}

	public boolean equals(Object pathArg) {
		Path path = (Path)pathArg;
		return path.from.equals(this.from) && path.to.equals(this.to);
	} 
}