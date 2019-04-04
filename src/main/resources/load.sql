--
-- Database: `professor`
--
CREATE DATABASE IF NOT EXISTS `professor` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `professor`;

-- --------------------------------------------------------

--
-- Table structure for table `instituto`
--

CREATE TABLE `instituto` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `sigla` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `instituto`
--

INSERT INTO `instituto` (`id`, `nome`, `sigla`) VALUES
(1, 'UNIVERSIDADE DA AMAZONIA', 'UNAMA');

-- --------------------------------------------------------

--
-- Table structure for table `professor`
--

CREATE TABLE `professor` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `titulacao` varchar(255) DEFAULT NULL,
  `id_instituto` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `professor`
--

INSERT INTO `professor` (`id`, `nome`, `titulacao`, `id_instituto`) VALUES
(1, 'JOÃO', 'MESTE', 1);

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `celular` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `perfil` char(1) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`id`, `celular`, `email`, `nome`, `perfil`, `senha`) VALUES
(1, '91999991111', 'fulano@seila.com.br', 'Fulano de Tal', 'A', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb'),
(2, '91999992222', 'beltrano@seila.com.br', 'Beltrano Jr', 'I', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb'),
(3, '91999993333', 'ciclano@seila.com.br', 'Ciclano da Silva', 'P', 'ca978112ca1bbdcafac231b39a23dc4da786eff8147c4e72b9807785afee48bb');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `instituto`
--
ALTER TABLE `instituto`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `professor`
--
ALTER TABLE `professor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_professor_id_instituto` (`id_instituto`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `instituto`
--
ALTER TABLE `instituto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `professor`
--
ALTER TABLE `professor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `professor`
--
ALTER TABLE `professor`
  ADD CONSTRAINT `FK_professor_id_instituto` FOREIGN KEY (`id_instituto`) REFERENCES `instituto` (`id`);
