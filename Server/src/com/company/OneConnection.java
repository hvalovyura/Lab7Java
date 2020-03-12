package com.company;

import java.io.*;
import java.net.Socket;

public class OneConnection extends Thread
{
    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;
    public String name;

    public OneConnection(Socket socket, String name) throws IOException
    {
        this.socket = socket;
        this.name = name;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start();
    }

    @Override
    public void run()
    {
        String word;
        try
        {
            while(true)
            {
                word = in.readLine();
                for(OneConnection connection: Server.serverList)
                {
                    //connection.send(word);
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
