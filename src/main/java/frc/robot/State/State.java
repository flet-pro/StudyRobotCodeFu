package frc.robot.State;

public abstract class State {
    /**
     * Stateの初期化
     * １回のみ実行
     */
    public abstract void initState();
    
    /**
     * Stateをリセット
     * Applyする前に必ず実行
     */
    public abstract void resetState();
}
