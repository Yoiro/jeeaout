package be.helha.groupe5.exceptions;

public class InvalidIdException extends Exception{
	public InvalidIdException(){
		super("L'ID que vous recherchez n'est pas valide");
	}
}
