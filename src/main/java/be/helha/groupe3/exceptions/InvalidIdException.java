package be.helha.groupe3.exceptions;

public class InvalidIdException extends Exception{
	public InvalidIdException(){
		super("L'ID que vous recherchez n'est pas valide");
	}
}
