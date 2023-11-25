package model;

public interface ModelObserver {
        void onModelChanged(String result, int[][] allNumberOracle);
}
