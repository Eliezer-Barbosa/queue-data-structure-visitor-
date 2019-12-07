package model.enums;

public enum PriorityLevel {
	LOW {
		@Override
		public String toString() {
			return "LOW";
		}
	},
	MEDIUM {
		@Override
		public String toString() {
			return "MEDIUM";
		}
	},
	
	HIGH {
		@Override
		public String toString() {
			return "HIGH";
		}
	}
}
