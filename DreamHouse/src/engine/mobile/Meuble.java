package engine.mobile;

import engine.map.Case;

public class Meuble extends MobileElement{
		private int apparence = 0 ;
		private int LargeurMeuble = 30;
		private int LongueurMeuble = 60; 

		
		public Meuble(Case position) {
			super(position);
		}


		public int getApparence() {
			return apparence;
		}


		public void setApparence(int apparence) {
			this.apparence = apparence;
		}


		public int getLargeurMeuble() {
			return LargeurMeuble;
		}


		public void setLargeurMeuble(int largeurMeuble) {
			LargeurMeuble = largeurMeuble;
		}


		public int getLongueurMeuble() {
			return LongueurMeuble;
		}


		public void setLongueurMeuble(int longueurMeuble) {
			LongueurMeuble = longueurMeuble;
		}

		public void incrementApparence() {
			apparence++;
		}

}
