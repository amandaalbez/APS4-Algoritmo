package exemplos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sorting {
    private static String selectedSorting = null;
    private static String selectedNumber = null;

    public static void main(String[] args) {
        // Criação do frame (janela)
        JFrame frame = new JFrame("Sorteando Algoritmos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400); // Tamanho da janela
        frame.setResizable(false); // Tornar a janela não redimensionável

        // Definindo a cor de fundo usando valores RGB (exemplo: azul claro)
        frame.getContentPane().setBackground(new Color(0, 29, 58)); // RGB: (100, 149, 237)

        // Criação do painel principal com BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setOpaque(false);  // Tornar o painel principal transparente

        // Criação e adição do título principal
        JLabel titleLabel = new JLabel("Sorteando Algoritmos", JLabel.CENTER);
        titleLabel.setFont(titleLabel.getFont().deriveFont(24.0f)); // Define o tamanho da fonte do título principal
        titleLabel.setForeground(new Color(255, 255, 255));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Criação do painel para os títulos e botões
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(4, 1, 10, 10)); // 4 linhas, 1 coluna, espaço de 10px entre componentes
        contentPanel.setOpaque(false);  // Tornar o painel de conteúdo transparente

        // Criação do título "Selecione o tipo de sorting"
        JLabel sortingTypeLabel = new JLabel("Selecione o tipo de algoritmo de ordenação:", JLabel.LEFT);
        sortingTypeLabel.setFont(sortingTypeLabel.getFont().deriveFont(18.0f)); // Tamanho da fonte do título h2
        sortingTypeLabel.setForeground(new Color(255, 255, 255));
        contentPanel.add(sortingTypeLabel);

        JPanel sortingButtonPanel = new JPanel();
        sortingButtonPanel.setLayout(new GridLayout(1, 3, 10, 10)); // 1 linha, 3 colunas
        sortingButtonPanel.setOpaque(false);  // Tornar o painel de botões transparente

        // Criação dos botões de sorting com tamanho reduzido
        RoundButton insertionSortButton = new RoundButton("Insertion Sort");
        RoundButton bucketSortButton = new RoundButton("Bucket Sort");
        RoundButton mergeSortButton = new RoundButton("Mergesort");

        // Reduzindo ainda mais o tamanho dos botões
        insertionSortButton.setFont(insertionSortButton.getFont().deriveFont(10.0f));
        bucketSortButton.setFont(bucketSortButton.getFont().deriveFont(10.0f));
        mergeSortButton.setFont(mergeSortButton.getFont().deriveFont(10.0f));

        // Adicionando ação aos botões de sorting, sem chamar checkSelection()
        insertionSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedSorting = "Insertion Sort";
            }
        });

        bucketSortButton.addActionListener(e -> {
            selectedSorting = "Bucket Sort";
        });

        mergeSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedSorting = "Mergesort";
            }
        });

        // Adicionando os botões de sorting ao painel de botões
        sortingButtonPanel.add(insertionSortButton);
        sortingButtonPanel.add(bucketSortButton);
        sortingButtonPanel.add(mergeSortButton);

        // Adicionando o painel de botões de sorting ao contentPanel
        contentPanel.add(sortingButtonPanel);

        // Criação do título "Selecione a quantidade de números"
        JLabel numberCountLabel = new JLabel("Selecione a quantidade de números:", JLabel.LEFT);
        numberCountLabel.setForeground(new Color(255, 255, 255));
        numberCountLabel.setFont(numberCountLabel.getFont().deriveFont(18.0f)); // Tamanho da fonte do título h2
        contentPanel.add(numberCountLabel);

        JPanel numberButtonPanel = new JPanel();
        numberButtonPanel.setLayout(new GridLayout(1, 3, 10, 10)); // 1 linha, 3 colunas
        numberButtonPanel.setOpaque(false);  // Tornar o painel de botões de números transparente

        // Criação dos botões de quantidade de números com tamanho reduzido
        RoundButton numbers1000Button = new RoundButton("1000_numbers");
        RoundButton numbers5000Button = new RoundButton("5000_numbers");
        RoundButton numbers10000Button = new RoundButton("10000_numbers");

        // Reduzindo ainda mais o tamanho dos botões
        numbers1000Button.setFont(numbers1000Button.getFont().deriveFont(10.0f));
        numbers5000Button.setFont(numbers5000Button.getFont().deriveFont(10.0f));
        numbers10000Button.setFont(numbers10000Button.getFont().deriveFont(10.0f));

        // Adicionando ação aos botões de quantidade de números
        numbers1000Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedNumber = "1000 números";
            }
        });

        numbers5000Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedNumber = "5000 números";
            }
        });

        numbers10000Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedNumber = "10000 números";
            }
        });

        // Adicionando os botões de quantidade de números ao painel de botões
        numberButtonPanel.add(numbers1000Button);
        numberButtonPanel.add(numbers5000Button);
        numberButtonPanel.add(numbers10000Button);

        // Adicionando o painel de botões de quantidade de números ao contentPanel
        contentPanel.add(numberButtonPanel);

        // Adicionando o contentPanel ao painel principal
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        // Criação do botão "Sorteio"
        RoundButton sortButton = new RoundButton("Sorteio");
        sortButton.setBackground(new Color(133, 229, 224));
        sortButton.setForeground(new Color(0, 29, 58));
        sortButton.setFont(sortButton.getFont().deriveFont(14.0f));

        // Adicionando ação ao botão "Sorteio"
        sortButton.addActionListener(e -> checkSelection());

        // Adicionando o botão "Sorteio" na parte inferior da janela
        mainPanel.add(sortButton, BorderLayout.SOUTH);

        // Adicionando o painel principal à janela
        frame.add(mainPanel);

        // Tornando a janela visível
        frame.setVisible(true);
    }

    // Método para verificar se ambos os botões foram selecionados
    private static void checkSelection() {
        if (selectedSorting != null && selectedNumber != null) {
            // Abrir uma nova janela para exibir o resultado
            showResultWindow();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione o algoritmo de ordenação e a quantidade de números.");
        }
    }

    // Método para exibir a nova janela com o resultado
    private static void showResultWindow() {
        JFrame resultFrame = new JFrame("Resultado");
        resultFrame.setSize(400, 200);

        JPanel resultPanel = new JPanel(new BorderLayout());

        JLabel resultTitle = new JLabel("Resultado da Seleção", JLabel.CENTER);
        resultTitle.setFont(resultTitle.getFont().deriveFont(20.0f));
        resultPanel.add(resultTitle, BorderLayout.NORTH);

        JLabel resultLabel = new JLabel("Sorting: " + selectedSorting + " | Números: " + selectedNumber, JLabel.CENTER);
        resultLabel.setFont(resultLabel.getFont().deriveFont(16.0f));
        resultPanel.add(resultLabel, BorderLayout.CENTER);

        resultFrame.add(resultPanel);
        resultFrame.setVisible(true);
    }

    // Classe interna personalizada para criar botões com bordas arredondadas
    static class RoundButton extends JButton {
        public RoundButton(String label) {
            super(label);
            setContentAreaFilled(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30); // Definir quão arredondada será a borda
            g2.dispose();
            super.paintComponent(g);
        }

        @Override
        protected void paintBorder(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getForeground());
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);
            g2.dispose();
        }

        @Override
        public Insets getInsets() {
            return new Insets(10, 10, 10, 10);
        }
    }
}
