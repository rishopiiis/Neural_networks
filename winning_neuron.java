public class SelfOrganizingMap {
    public static int findWinningNeuron(double[][] weightVectors, double[] inputVector) {
        int numNeurons = weightVectors.length;
        double minDistance = Double.MAX_VALUE;
        int winningNeuronIndex = -1;

        // Iterate through all neurons
        for (int i = 0; i < numNeurons; i++) {
            double distance = 0.0;

            // Calculate Euclidean distance between input vector and neuron weights
            for (int j = 0; j < inputVector.length; j++) {
                distance += Math.pow(weightVectors[i][j] - inputVector[j], 2);
            }
            distance = Math.sqrt(distance);

            // Update the winning neuron if a smaller distance is found
            if (distance < minDistance) {
                minDistance = distance;
                winningNeuronIndex = i;
            }
        }

        return winningNeuronIndex; // Return the index of the winning neuron
    }

    public static void main(String[] args) {
        // Example: Define weight vectors for 4 neurons
        double[][] weightVectors = {
            {0.2, 0.6, 0.5},
            {0.8, 0.4, 0.7},
            {0.3, 0.9, 0.2},
            {0.5, 0.1, 0.8}
        };

        // Define an input vector
        double[] inputVector = {0.4, 0.5, 0.6};

        // Find the winning neuron
        int winningNeuron = findWinningNeuron(weightVectors, inputVector);

        System.out.println("The winning neuron index is: " + winningNeuron);
    }
}
