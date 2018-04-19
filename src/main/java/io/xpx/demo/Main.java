package io.xpx.demo;

import java.io.IOException;
import java.util.Scanner;

import org.nem.core.node.NodeEndpoint;
import io.nem.ApiException;
import io.nem.xpx.builder.UploadPathParameterBuilder;
import io.nem.xpx.facade.Upload;
import io.nem.xpx.facade.connection.LocalHttpPeerConnection;
import io.nem.xpx.facade.model.UploadData;
import io.nem.xpx.model.PeerConnectionNotFoundException;
import io.nem.xpx.model.UploadException;
import io.nem.xpx.model.UploadPathParameter;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	// arg0 = directory
	// arg1 = public key
	// arg2 = private key
	// arg3 = description

	public static void main(String[] args) {

		try {
			boolean tryagain = true;
			Scanner reader = new Scanner(System.in);
			System.out.println("");
			System.out.println("Welcome to Simple Website Static Hosting Tool by ProximaX");
			System.out.println("");
			System.out.println("1. Make sure you load your folder in this current box.");
			System.out.println("2. Make sure ProximaX IPFS is Running! ");
			System.out.println("3. Make sure to enter the Root directory of your site. ");
			System.out.println("");
			System.out.println("Ready? Lets begin! (Hit Enter)");
			reader.nextLine();
			while (tryagain) {

				System.out.println("Root Directory of your site that's in this server/box: ");
				String directory = reader.next(); // Scans the next token of the input as an int.
				System.out.println("Your Private Key (this won't be transferred over the wire): ");
				String privateKey = reader.next(); // Scans the next token of the input as an int.
				System.out.println("Your Public Key (this won't be transferred over the wire): ");
				String publicKey = reader.next(); // Scans the next token of the input as an int.
				System.out.println("Any Description: ");
				String desc = reader.next(); // Scans the next token of the input as an int.
				
				System.out.println("");
				System.out.println("Loading..... to ProximaX.....");
				System.out.println("");
				LocalHttpPeerConnection localPeerConnection = new LocalHttpPeerConnection(
						new NodeEndpoint("http", "104.128.226.60", 7890));

				Upload upload = new Upload(localPeerConnection);
				UploadPathParameter pathParameter = UploadPathParameterBuilder.senderPrivateKey(privateKey)
						.recipientPublicKey(publicKey).path(directory).keywords(desc).build();

				UploadData uploadData = upload.uploadPath(pathParameter);
				System.out.println("Done! Your Hash: " + uploadData.getNemHash());
				System.out.println("");
				System.out.println(
						"You can view your site root is not mapped to a NEM Hash. Use the following url to test");
				System.out.println("https://gateway.proximax.io/xpx/directory/load/static/<Hash>/<file inside root>");
				System.out.println("");
				System.out.println("Try again? (Y/N): ");
				String tryStr = reader.next(); // Scans the next token of the input as an int.

				if (tryStr.toLowerCase().equals("y")) {
					tryagain = true;
				} else {
					tryagain = false;
				}
	
			}

		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PeerConnectionNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
