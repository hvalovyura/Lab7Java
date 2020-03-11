package com.company;

import java.io.*;
import java.net.Socket;

public class OneConnection extends Thread
{
    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    private String name;

    public OneConnection(Socket socket, String name) throws IOException
    {
        this.socket = socket;
        this.name = name;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start();
    }

    public void run()
    {
        String word;
        try
        {
            while(true)
            {
                word = in.readLine();
                if(word.equals("stop"))
                {
                    break;
                }
                for(OneConnection connection: Server.ServerList)
                {
                    connection.send(word);
                }
            }
        }
        catch (IOException ex)
        {

        }
    }

    private void send(String msg)
    {
        try
        {
            out.write(msg + "\n");
            out.flush();
        }
        catch(IOException ex)
        {

        }
    }

}
