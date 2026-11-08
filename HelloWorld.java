int procNumber() {
	return Runtime.getRuntime().availableProcessors();
}

void main() {
	final String AUTHOR = "Danilo Pianini";
	IO.println("This program is running in a PC with " + procNumber() + " logic processors!");
	IO.println("This program has been realised by " + AUTHOR);
}
