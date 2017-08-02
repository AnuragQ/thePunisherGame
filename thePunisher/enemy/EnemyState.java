package enemy;

public interface EnemyState {
	int DEFAULT_STAND_RIGHT = 1;
	int DEFAULT_MOVE_RIGHT=2;
	int PUNCH_RIGHT= 4;
	int KICK_RIGHT=5;
	int DIE_RIGHT=6;
	int RECOIL_RIGHT=7;
	
	int DEFAULT_STAND_LEFT = 9;
	int DEFAULT_MOVE_LEFT=10;
	int PUNCH_LEFT = 12;
	int KICK_LEFT=13;
	int DIE_LEFT=14;
	int RECOIL_LEFT=15;
	
}
