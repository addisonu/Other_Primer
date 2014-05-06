#!/usr/bin/perl
use CGI qw(:standard);
print header, start_html(-title=>"Pick color", -BGCOLOR=>"black"), h1("pick color");
sub pick_color
                {
                        my $rand_num;
                        my $rand_let;
                        my $choose_num;# 1 -> num use $rand_num, 0 -> use $rand_let

                        my $t_color = "#";
                        my $b_color = "#";

                        for($n = 0; $n < 6; $n++)
                                {
					my $rand_num = int(rand(10)) + 48;
                        		my $rand_let = int(rand(6)) + 65;
                                        my $choose_num = int(rand(2));

					if($choose_num)
                                        	{$b_color = $b_color.chr($rand_num); print p( "$b_color <br>");}
                                        else
                                        	{$b_color = $b_color.chr($rand_let); print p("$b_color <br>");}
                                }
	               for($m = 0; $m < 6; $m++)
                                {
                                 	my $rand_num = int(rand(10)) + 48;
                                        my $rand_let = int(rand(6)) + 65;
                                        my $choose_num = int(rand(2));

                                        if($choose_num)
                                                {$t_color = $t_color.chr($rand_num); print p($t_color);}
                                        else
                                                {$t_color = $t_color.chr($rand_let); print p("$t_color");}                              		   }
			#print hr({-COLOR=>"$b_color"});
                        #print p("b_color = $b_color <br>");#{-style=>'background-color: black;color: magenta'
			print p({-style=>"color: $t_color; background-color: $b_color"}, "t_color = $t_color <br>", "b_color = $b_color <br>");
			#print hr();
                 
		}
pick_color();
print end_html;
