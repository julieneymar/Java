package gestion_eleves;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.beans.Statement;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class enregistrementClient extends JFrame
{
	// lesVariables
	//connectionClient con = new connectionClient();
	String path = null;
	byte[] userimage = null;
	Statement pst;
	ResultSet rs;
	JLabel lblTitre , lblcode, lblnom, lblclasse, lblsex, image1;
	JTextField txtcode, txtnom;
	JComboBox<String> combosex, comboclasse;
	JButton btnenregistrement, btnsupprimer, btntelecharger; 
	JTable table, table1;
	JScrollPane scroll, scroll1;
	
	public void init() 
	{
		table1 = new JTable();
		scroll1 = new JScrollPane();
		scroll1.setBounds(10,280,770,130);
		scroll1.setViewportView(table1);		
	}
	
	public enregistrementClient() 
	{
		//partieFenettre
		super.setTitle("Enregistrement des clients");
		super.setSize(800,450); // tailleDeLaFenetre
		super.setLocationRelativeTo(null); // CentreLaFenetre
		super.setResizable(true); //permetreAgrandir
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // permetrreDeFermerLaFenetre
		JPanel pn = new JPanel(); // c'estLaPaumeDeLaFenetre
		pn.setLayout(null);
		add(pn);
		pn.setBackground(new Color(220,210,220));
		
		// partieTitre
		lblTitre = new JLabel ("Partie d'enregistrement"); // louerUneespace
		lblTitre.setBounds(250, 10, 800, 30); // mesureDelespaceEtl'interieurDel'espace
		lblTitre.setFont(new Font ("Arial", Font.BOLD, 24));  // policeGrastaille
		lblTitre.setForeground(new Color (0,0,250)); // couleur
		pn.add(lblTitre);
		
		//CodeEleve
		lblcode = new JLabel("NUMERO ELEVE");
		lblcode.setBounds(60, 60, 800, 30);
		lblcode.setFont(new Font ("Arial", Font.BOLD,14));
		lblcode.setForeground(new Color (0,0,0));
		pn.add(lblcode);
		
		txtcode = new JTextField(); // creerUnChampsDeTexte
		txtcode.setBounds(200,60,150,30);
		txtcode.setFont(new Font("Arial",Font.BOLD,16));
		pn.add(txtcode);
		
		//NomEleve
		lblnom = new JLabel("NOM ET PRENOM");
		lblnom.setBounds(60, 100, 800, 30);
		lblnom.setFont(new Font ("Arial", Font.BOLD,14));
		lblnom.setForeground(new Color (0,0,0));
		pn.add(lblnom);
		
		txtnom = new JTextField(); // creerUnChampsDeTexte
		txtnom.setBounds(200,100,310,30);
		txtnom.setFont(new Font("Arial",Font.PLAIN,14));
		pn.add(txtnom);
		
		//SexeEleve
		
		lblsex = new JLabel("SEX");
		lblsex.setBounds(60, 140, 800, 30);
		lblsex.setFont(new Font ("Arial", Font.BOLD,16));
		lblsex.setForeground(new Color (0,0,0));
		pn.add(lblsex);
		
		combosex = new JComboBox(); // listeRoulante
		combosex.setBounds(200, 140, 100, 30);
		combosex.setFont(new Font("Arial",Font.PLAIN,14));
		combosex.addItem("");
		combosex.addItem("Masculin");
		combosex.addItem("Feminin");
		pn.add(combosex);
		
		//classEleve
		lblclasse = new JLabel("CLASSE");
		lblclasse.setBounds(60, 180, 800, 30);
		lblclasse.setFont(new Font ("Arial", Font.BOLD,16));
		lblclasse.setForeground(new Color (0,0,0));
		pn.add(lblclasse);
		
		comboclasse = new JComboBox();
		comboclasse.setBounds(200, 180, 100, 30);
		comboclasse.setFont(new Font("Arial",Font.PLAIN,14));
		comboclasse.addItem("");
		comboclasse.addItem("6EME");
		comboclasse.addItem("5EME");
		comboclasse.addItem("4EME");
		comboclasse.addItem("3EME");
		comboclasse.addItem("2EME");
		comboclasse.addItem("1EME");
		comboclasse.addItem("TERMINAL");
		pn.add(comboclasse);
		
		//photo
		
		image1 = new JLabel("PHOTO");
		image1.setBounds(530, 60, 150, 150);
		image1.setFont(new Font("Arial",Font.BOLD,16));
		image1.setBackground(new java.awt.Color(225,0,0));
		image1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); // CentreL'image
		image1.setBorder(javax.swing.BorderFactory.createEtchedBorder()); // bordureDucontourdujlabel
		image1.addMouseListener(new java.awt.event.MouseAdapter()  // pourCliquer(mouseListener)
		{
			public void mouseClicked(java.awt.event.MouseEvent evt) 
			{
				image1MouseClicked(evt);
			}
			private void image1MouseClicked(MouseEvent evt) 
			{
				JFileChooser pic = new JFileChooser();  // permetD'applerlabibiotheque
				pic.showOpenDialog(null);  // ouvrirLabibliotheque avecShopendialog
				
				File picture = pic.getSelectedFile();  // permetDeSelectionnerunfile
				path = picture.getAbsolutePath();
				BufferedImage img; // recupererOucreeruneinstance duFichier
				try 
				{
					img = ImageIO.read(pic.getSelectedFile());  // imageioPermetdelirelefichier
					ImageIcon imageic = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT));
					image1.setIcon(imageic);
					File image = new File(path);
					FileInputStream fis = new FileInputStream(image);
					ByteArrayOutputStream bos = new ByteArrayOutputStream();
					byte [] buff = new byte[1024];
					
					for (int i; (i = fis.read(buff)) != -1;)
					{
						bos.write(buff,0,i);
					}
					userimage = bos.toByteArray();
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}); 
		pn.add(image1);
		
		//boutonD'enregistrement
		btnenregistrement = new JButton("ENREGISTREER");
		btnenregistrement.setBounds(200,230,150,30);
		btnenregistrement.setFont(new Font("Arial",Font.BOLD,15));
		btnenregistrement.setForeground(Color.black);
		btnenregistrement.setBackground(new Color(173,216,230));
		
		btnenregistrement.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev) 
			{
				String num, nom, sexe, classe;
				num = txtcode.getText();
				nom = txtnom.getText();
				sexe = combosex.getSelectedItem().toString();
				 
				String rq = "insert into tb_eleve(code,nom,sexe,classe,photo) values (?,?,?,?))";
				/*try 
				{
					PreparedStatement ps = con.maConnection().prepareStatement(rq);
					ps.setString(1, num);
					ps.setString(2, nom);
					ps.setString(2, sexe);
					ps.setString(2, classe);
					ps.setBytes(5, userimage);
					ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "Eleve Enregistrer!",null,JOptionPane.INFORMATION_MESSAGE)
;
					con.maConnexion().close();
					
				} catch (SQLException ex)
				{
					JOptionPane.showMessageDialog(null, "Erreur!" + ex.getMessage(),null,JOptionPane.ERROR_MESSAGE);
					
				}*/
				dispose();
				enregistrementClient elv = new enregistrementClient();
				elv.setVisible(true);
			}
		});
		pn.add(btnenregistrement);
		
		// buttonSupression
		btnsupprimer = new JButton("Supprimer");
		btnsupprimer.setBounds(370,230,150,30);
		btnsupprimer.setFont(new Font("Arial",Font.BOLD,15));
		btnsupprimer.setForeground(Color.black);
		btnsupprimer.setBackground(new Color(173,216,230));
		
		/*btnsupprimer.addActionListener( new ActionListener()
		{
			public void actionperformed(ActionEvent ev) 
			{
				String num,nom,sexe,classe;
				num = txtcode.getText();
				String rq = "delecte from tb_eleve where code" + num + "'";
				try 
				{
					pst = con.maConnection().createStatement();
					pst.executeUpdate(rq); 
					JOptionPane.showMessageDialog(null, "Eleve supprimer!",null,JOptionPane.INFORMATION_MESSAGE);
					//con.maConnection(.close();
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Erreur!" + ex.getMessage(), null,JOptionPane.ERROR_MESSAGE);
				}
				dispose();
				enregistrementClient elv = new enregistrementClient();
				elv.setVisible(true);
				}
		});*/
		
		pn.add(btnsupprimer);
		
		
		// listeDeseleves
		
		DefaultTableModel model = new DefaultTableModel();
		init();
		pn.add(scroll1);
		model.addColumn("code");
		model.addColumn("Nom et Prenom");
		model.addColumn("sexe");
		model.addColumn("classe");
		
		table1.setModel(model);
		String sql = "select + from tb_eleve order by code desc";
		
		/*try 
		{
			pst = con.maConnection().createStatement();
			rs = pst.executeQuery(sql);
			while (rs.next()) 
			{
				model.addRow(new object[] {
						rs.getString("code"),
						rs.getString("nom"),
						rs.getString("sex"),
						rs.getString("classe")
				});
			}
		} catch (Exception e) 
		{
			JOptionPane.showMessageDialog(null, "Erreur!",null,JOptionPane.ERROR_MESSAGE);
			
		}*/
		
		table1.addMouseListener(new MouseAdapter() 
		{
			public void mousereleased (java.awt.event.MouseEvent evt) 
			{
				table1MouseReleased(evt);
			}
			private void table1MouseReleased(MouseEvent evt) 
			{
				int selectionner = table1.getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) table1.getModel();
				txtcode.setText(model.getValueAt(selectionner, 0).toString());
				txtnom.setText(model.getValueAt(selectionner, 1).toString());
				combosex.setSelectedItem(model.getValueAt(selectionner, 2).toString());
				comboclasse.setSelectedItem(model.getValueAt(selectionner, 3).toString());
				
			}
		});
		
		
	}
	public static void main(String[] args)
	{
		enregistrementClient en = new enregistrementClient();
		en.setVisible(true);

	}
	

}
