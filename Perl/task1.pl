#!/usr/local/bin/perl
# File Name: task1.pl
# Program Description: Simple file modifications using perl functions and system commands

#command line arguments
#[0] => name of new directory [1] => name of existing file to be copied to newfile

#Task 1

#Optional prompt for user input
if(!$ARGV[0] && !$ARGV[1])
{
print "Please enter the name of the new directory\n";
chomp($dir = <>);
$ARGV[0] = $dir;
print "Please enter the name of the file to be copied\n";
chomp($file = <>);
$ARGV[1] = $file;
}
#Echo user inputs
print "The new subdirectory will be named $ARGV[0]\n";
print "The file that will be copied is named $ARGV[1]\n";

#make directory
mkdir($ARGV[0], 0755) || die "The directory $ARGV[0] couldn't be created: $!\n";

#create hmwkfile2 by copying hmwkfile
$new_file_name = $ARGV[1]."2";
$new_file = `touch ./$ARGV[0]/$new_file_name; cp $ARGV[1] ./$ARGV[0]/$new_file_name`;
print "$new_file\n";

#perfom ls -l on both files
$ls_l = `ls -l $ARGV[1]; cd $ARGV[0]; ls -l $new_file_name`;
print "$ls_l\n";

#perform du on parent directory
$du_par_dir = `du`;
print "$du_par_dir\n";
