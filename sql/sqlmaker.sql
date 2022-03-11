DROP SCHEMA IF EXISTS `ordermanagement` ;
CREATE SCHEMA IF NOT EXISTS `ordermanagement`;
USE `ordermanagement` ;

CREATE TABLE IF NOT EXISTS `client` (
  `id_client` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `adress` VARCHAR(45) NOT NULL,
  `phone_nr` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_client`));
  
  CREATE TABLE IF NOT EXISTS `product` (
  `id_product` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `quantity` INT NOT NULL,
  PRIMARY KEY (`id_product`));
  
  CREATE TABLE IF NOT EXISTS `order` (
    `id_order` INT NOT NULL AUTO_INCREMENT,
    `id_client` INT NOT NULL,
    `id_product` INT NOT NULL,
    `quantity` INT NOT NULL,
    PRIMARY KEY (`id_order`),
    FOREIGN KEY (`id_client`)
        REFERENCES `client` (`id_client`),
    FOREIGN KEY (`id_product`)
        REFERENCES `product` (`id_product`)
);

INSERT INTO `product` (`name`,`quantity`) VALUES ('Skittles', 300),('Red Vines', 500 ),('Reeses pieces', 1200),('Gummi Bears', 300),('Subway', 120),('Pizza Hut', 2500),('Pear', 1000),('Orange', 200),('Poppy seeds', 1110),('Havarti cheese', 2500),('Cinnamon Bread', 1000),('Cream Cheese Frosting', 3200),('Mango Lassi', 320),('Carbonara', 1200),('Pineapple', 600),('Fan', 352),('Alarm clock', 125),('Pocket knife', 35),('Sword', 568),('Basket', 253),('Skateboard', 326),('Handlebars', 120),('Wine holder', 135),('Calendar', 2000),('Baking tray', 1632),('Bed', 1354),('Table', 1203),('Floor lamp', 130),('Cutting board', 256),('Mug', 456),('Fork', 852),('Calculator', 547),('Canoe', 587),('Rocking chair', 423),('Vase', 52),('Flashlight', 48),('Spoon', 8874),('Glasses', 458),('Can opener', 258),('Bowl', 544),('Playing cards', 88),('Ring', 77),('Toy train', 56),('Frying pan', 426);

INSERT INTO `client` (`name`,`adress`,`phone_nr`) VALUES ("Sydnee Nielsen","Ap #212-9204 Risus. Av.","07 83 90 39 37"),("Keely Rowland","2665 Lacus St.","07 71 64 08 04"),("Octavia Finley","P.O. Box 644, 3455 Libero St.","05 32 25 88 36"),("Anthony Bell","303-6663 Etiam Street","04 01 57 99 95"),("Hiram Whitley","7992 Quisque Road","05 37 15 14 40"),("Echo May","Ap #431-4058 Senectus Avenue","06 80 34 10 18"),("Pascale Shepard","3317 Lacinia. Rd.","01 84 61 36 90"),("Moses Gutierrez","Ap #369-2251 Praesent Av.","02 00 19 03 58"),("Gisela Strong","Ap #131-591 Magna. St.","08 05 50 38 65"),("Echo Perez","309-319 Dui. Street","04 25 30 62 91");
INSERT INTO `client` (`name`,`adress`,`phone_nr`) VALUES ("Wylie Calhoun","538-3344 Et Road","02 14 93 93 29"),("Theodore Baldwin","Ap #929-4915 Sed Avenue","08 14 55 08 61"),("Armand Lowe","474-5008 Risus. Road","05 89 34 41 70"),("Macaulay Porter","343-6161 Pellentesque Rd.","07 34 41 68 84"),("Eaton Alvarez","Ap #429-7180 Urna Rd.","06 16 76 30 53"),("Uriel Roberts","Ap #467-8197 Commodo St.","03 90 87 55 62"),("Jillian Peck","111-3548 Lacinia. Ave","04 74 42 87 03"),("Madeline Workman","P.O. Box 890, 7359 Enim. Road","04 25 52 88 89"),("Leigh Benson","Ap #457-8513 Mattis. Rd.","01 74 72 46 48"),("Dakota Daniels","P.O. Box 483, 7113 Dolor. Street","08 45 28 01 82");
INSERT INTO `client` (`name`,`adress`,`phone_nr`) VALUES ("Travis Foley","249-2703 Pellentesque. Ave","02 02 92 13 51"),("Karyn Roy","Ap #596-7769 Ultrices Avenue","02 52 62 18 35"),("Graiden Mejia","P.O. Box 296, 351 Felis Street","05 92 89 39 85"),("Roary Nicholson","P.O. Box 901, 7903 Suspendisse Ave","07 23 68 39 19"),("Isaac Mercer","P.O. Box 645, 1084 At, Avenue","03 85 11 75 53"),("Ian Vaughn","732-4403 Nascetur St.","08 17 46 75 62"),("Alfonso Burris","P.O. Box 265, 3401 Tellus Av.","06 50 69 75 90"),("Amelia Noble","P.O. Box 473, 8324 Dapibus Av.","04 85 15 12 22"),("Bryar Mcgee","P.O. Box 507, 1324 Gravida St.","09 29 43 54 45"),("Arden Herman","633-7779 Cubilia Avenue","05 88 34 60 30");
INSERT INTO `client` (`name`,`adress`,`phone_nr`) VALUES ("Eden Henson","9897 Sem Street","02 51 93 19 32"),("Urielle Fitzgerald","329-9107 Adipiscing St.","03 65 20 18 80"),("Kalia Church","Ap #420-4768 Dui, Av.","09 57 46 47 54"),("Petra Stephens","Ap #960-6421 Risus. St.","02 92 53 84 77"),("Kameko Benjamin","692-9927 Non St.","07 16 06 84 65"),("Lois Sharpe","2669 Nulla Rd.","05 62 14 83 21"),("Declan Chen","6692 Rutrum St.","02 27 13 76 18"),("Mannix Bolton","680-2412 Molestie St.","03 83 06 90 26"),("Uriah Suarez","9516 Nullam Ave","06 04 41 86 28"),("Melodie Wall","5808 Risus. Av.","04 45 41 78 82");
INSERT INTO `client` (`name`,`adress`,`phone_nr`) VALUES ("Leandra Brady","P.O. Box 298, 905 Vitae Rd.","09 28 35 21 40"),("Bell Kemp","726 Porttitor St.","01 26 08 05 48"),("Renee Frazier","800-2157 Lacus. Ave","04 11 90 37 85"),("Virginia Sampson","4504 Nunc St.","02 79 89 22 35"),("Brennan Solomon","P.O. Box 432, 3409 Nec Rd.","09 17 26 09 38"),("Bruno Gordon","1919 Vulputate, Street","07 58 84 05 50"),("Noel Wright","250 Bibendum Ave","09 43 40 42 25"),("Unity Calderon","Ap #980-6300 Fringilla. St.","05 14 59 35 08"),("Gay Drake","346-714 Et Rd.","09 72 70 01 52"),("Charde Reese","818-9023 Mauris Rd.","05 80 49 24 01");
INSERT INTO `client` (`name`,`adress`,`phone_nr`) VALUES ("Simon Stuart","866-3716 Montes, Street","05 68 79 94 50"),("Rebecca Willis","752-7959 Imperdiet St.","06 68 39 52 45"),("Isaac Hahn","5807 Cursus Street","08 41 68 00 76"),("Jolie David","3272 Feugiat Ave","04 95 60 01 96"),("Driscoll Oconnor","401-2094 Sit Rd.","08 41 72 67 23"),("Lee Grimes","Ap #423-4337 Ac Street","09 70 68 74 48"),("Basia Page","885-3468 Dignissim St.","09 48 09 81 15"),("Nichole Clemons","P.O. Box 871, 2838 Duis Av.","03 26 02 52 69"),("Kylynn Hayes","Ap #354-9160 Et Rd.","01 06 24 89 92"),("Christen Johnson","P.O. Box 134, 7955 Vulputate Ave","04 25 29 72 46");
INSERT INTO `client` (`name`,`adress`,`phone_nr`) VALUES ("Declan Irwin","P.O. Box 824, 2233 Euismod St.","05 49 79 49 92"),("Ariana Rice","413-1905 Pharetra Avenue","04 38 65 92 46"),("Ryan Schwartz","Ap #347-4272 Aliquam Ave","05 11 98 65 82"),("Zeph Oneal","6826 Ultricies Street","04 90 39 26 82"),("Carson Ball","Ap #216-7805 A Avenue","02 46 41 00 45"),("Audrey Watts","1761 Sagittis Road","09 45 73 03 72"),("Tate Serrano","300-5785 A, St.","05 83 23 28 59"),("Arden Gallegos","344-9388 Erat Avenue","08 68 53 68 09"),("Chloe Carrillo","P.O. Box 561, 5994 Eu Road","06 61 22 57 76"),("Xena Hester","1317 Aliquet Av.","06 41 09 42 28");
INSERT INTO `client` (`name`,`adress`,`phone_nr`) VALUES ("Theodore Ramos","Ap #532-512 Nulla Street","03 44 83 69 82"),("Claudia Mooney","408-7058 Ante. St.","05 95 24 61 85"),("Gisela Munoz","P.O. Box 137, 3055 Massa. Road","02 16 42 82 11"),("Odysseus Doyle","Ap #839-5602 Vitae, Av.","03 50 72 21 04"),("Ignatius Logan","744-7567 Imperdiet St.","09 38 91 92 10"),("Kadeem Estes","Ap #817-4935 Ut St.","07 65 22 92 00"),("Rhiannon Graham","7801 Varius Avenue","04 81 06 51 16"),("Gisela Baxter","Ap #499-6802 Lorem. Avenue","01 78 00 12 82"),("Benjamin Summers","189-8057 Et, St.","09 34 00 30 95"),("Karen Douglas","P.O. Box 177, 2939 Metus. Av.","08 05 33 58 48");
INSERT INTO `client` (`name`,`adress`,`phone_nr`) VALUES ("Jemima Wilkins","4789 Placerat, Road","08 61 97 26 74"),("Ezekiel Oneill","746-1371 Dignissim Avenue","08 75 18 05 44"),("Oliver Roberson","Ap #222-910 Praesent Rd.","07 50 27 99 02"),("Chase Ayers","6146 Sed Ave","05 62 89 84 37"),("Devin Pickett","686-5654 Malesuada Street","01 18 62 41 27"),("Demetria Greene","Ap #138-8156 Dui. Rd.","07 21 02 19 84"),("Kiara Henson","P.O. Box 781, 9408 Fusce St.","04 84 29 34 67"),("Jolie Schultz","P.O. Box 793, 1830 Sed Avenue","05 74 99 45 55"),("Noelle Horne","6605 Metus. Rd.","06 23 31 65 52"),("Abel Knapp","6208 Elit. Av.","07 46 12 96 91");
INSERT INTO `client` (`name`,`adress`,`phone_nr`) VALUES ("Raya Drake","P.O. Box 298, 2774 Tincidunt Rd.","01 93 71 24 83"),("Joshua Delacruz","P.O. Box 591, 4326 Rutrum, Av.","04 80 34 26 81"),("Upton Hale","P.O. Box 689, 2399 Egestas Avenue","05 89 44 87 01"),("Neve Dudley","Ap #939-4619 Turpis. St.","06 20 69 66 58"),("Gray Cohen","Ap #327-2765 Arcu Avenue","01 32 25 20 70"),("Mohammad Hayes","5754 Auctor Rd.","06 32 37 97 41"),("Tucker Mcdaniel","Ap #316-4304 Aliquam Avenue","04 17 24 23 59"),("Amena Beck","Ap #314-5921 Parturient Ave","01 10 15 43 22"),("Noble Spears","307-7451 Nunc Av.","03 81 04 38 27"),("Dieter Monroe","P.O. Box 850, 4633 Nascetur Rd.","09 78 57 70 70");

INSERT INTO ordermanagement.order (id_client, id_product, quantity)
VALUES (2,3,120), (1,1,100);


  
