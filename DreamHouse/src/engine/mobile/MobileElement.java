package engine.mobile;

import engine.map.Case;

public abstract class MobileElement {
	

		private Case position;
		

		public MobileElement(Case position) {
			this.position = position;
		}

		public Case getPosition() {
			return position;
		}

		public void setPosition(Case position) {
			this.position = position;
		}

	

}
